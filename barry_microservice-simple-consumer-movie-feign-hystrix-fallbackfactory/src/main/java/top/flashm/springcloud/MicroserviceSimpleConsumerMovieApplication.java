package top.flashm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MicroserviceSimpleConsumerMovieApplication {
	
/*	@Bean
	@LoadBalanced//使用Ribbon实现负载均衡
	public RestTemplate returnRestTemplate(){
		return new RestTemplate();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleConsumerMovieApplication.class, args);
	}
}
