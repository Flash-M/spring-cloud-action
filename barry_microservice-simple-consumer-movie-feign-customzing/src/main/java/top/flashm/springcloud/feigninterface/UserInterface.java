package top.flashm.springcloud.feigninterface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Param;
import feign.RequestLine;
import top.flashm.springcloud.config.FeignConfiguration;
import top.flashm.springcloud.entity.User;

@FeignClient(name = "microservice-provider-user",configuration=FeignConfiguration.class)
public interface UserInterface {
	//@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	
	/**
	 * 使用feign原生注解进行声明式调用
	 * @param id
	 * @return
	 */
	@RequestLine(value="GET /{id}")
	public User findById(@Param("id") Long id);

}
