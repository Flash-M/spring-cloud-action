package top.flashm.springcloud.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

import top.flashm.config.RibbonConfiguration;

//使用@RibbonClient注解为特定name的RibbonClient自定义配置，RibbonConfiguration属性指定特定的配置
@Configuration
@RibbonClient(name = "microservice-provider-user", configuration = RibbonConfiguration.class)
public class ProviderUserConfiguration {

}
