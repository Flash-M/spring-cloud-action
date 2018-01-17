package top.flashm.springcloud.feigninterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import feign.Param;
import feign.RequestLine;
import feign.hystrix.FallbackFactory;
import top.flashm.config.FeignConfiguration;
import top.flashm.springcloud.entity.User;
import top.flashm.springcloud.feigninterface.UserInterface.UserFallbackFactory;

@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class, fallbackFactory = UserFallbackFactory.class)
public interface UserInterface {
	// @RequestMapping(value = "/{id}", method = RequestMethod.GET)

	/**
	 * 使用feign原生注解进行声明式调用
	 * 
	 * @param id
	 * @return
	 */
	@RequestLine(value = "GET /{id}")
	public User findById(@Param("id") Long id);

	@Component
	public class UserFallbackFactory implements FallbackFactory<UserInterface> {
		private static final Logger LOGGER = LoggerFactory.getLogger(UserFallbackFactory.class);

		@Override
		public UserInterface create(Throwable cause) {
			return new UserInterface() {

				@Override
				public User findById(Long id) {
					// 日志最好放在各个fallback方法中，而不要直接放在create方法中。
					// 否则在引用启动时，就会打印该日志。
					// 详见https://github.com/spring-cloud/spring-cloud-netflix/issues/1471
					UserFallbackFactory.LOGGER.info("fallback; reason was:", cause);
					User user = new User();
					user.setId(-1L);
					user.setUsername("默认用户");
					return user;
				};
			};
		}

	}
}
