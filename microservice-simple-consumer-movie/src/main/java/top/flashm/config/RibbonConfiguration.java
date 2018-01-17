package top.flashm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * Ribbon客户端自定义配置
 * 该类不应该在主程序的上下文的@ComponentScan中
 * @author Barry
 *
 */
@Configuration
public class RibbonConfiguration {
	
	/*@Bean
	public IRule ribbonRule() {
		//负载均衡规则改成随机
		return new RandomRule();
	}*/

}
