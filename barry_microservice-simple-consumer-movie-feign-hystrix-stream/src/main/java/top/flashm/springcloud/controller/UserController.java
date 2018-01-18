package top.flashm.springcloud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import top.flashm.springcloud.entity.User;
import top.flashm.springcloud.feigninterface.UserInterface;

@RestController
public class UserController {

	/*@Autowired
	private RestTemplate restTemplate;*/
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private UserInterface userInterface;
	
	public static final Logger logger = LoggerFactory.getLogger(User.class);
	
	@GetMapping("{id}")
	public User findById(@PathVariable Long id){
		//restTemplate实际上是一个Riboon的客户端，当Ribbon与Eureka配合使用时，会自动将虚拟主机名映射成微服务的网络地址
		//return restTemplate.getForObject("http://microservice-provider-user/"+id, top.flashm.springcloud.entity.User.class);
	
		//使用feign进行声明式restAPI调用
		return userInterface.findById(id);
	}
	
	@GetMapping("serviceInstances")
	public List<ServiceInstance> serviceInstances(){
		return discoveryClient.getInstances("microservice-provider-user");
	}
	
	@GetMapping("loadUserInstance")
	public void loadUserInstance(){
		ServiceInstance userInstance = loadBalancerClient.choose("microservice-provider-user");
		logger.info("{}:{}:{}",userInstance.getServiceId(),userInstance.getHost(),userInstance.getPort());
	}
}
