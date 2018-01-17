package top.flashm.springcloud.feigninterface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import feign.Param;
import feign.RequestLine;
import top.flashm.springcloud.config.FeignConfiguration;
import top.flashm.springcloud.entity.User;
import top.flashm.springcloud.feigninterface.UserInterface.UserFallback;

@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class, fallback = UserFallback.class)
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
	public class UserFallback implements UserInterface {

		@Override
		public User findById(Long id) {
			User user = new User();
			user.setId(-1L);
			user.setUsername("默认用户");
			return user;
		}

	}
}
