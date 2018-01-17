package top.flashm.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;


/**
 * feign配置类
 * @author Barry
 *
 */
@Configuration
public class FeignConfiguration {
	
	/**
	 * 使用feign原始契约，这样可以使用feign原生的注解
	 * @return
	 */
	@Bean
	public Contract feignContract(){
		return new feign.Contract.Default();
	}

}
