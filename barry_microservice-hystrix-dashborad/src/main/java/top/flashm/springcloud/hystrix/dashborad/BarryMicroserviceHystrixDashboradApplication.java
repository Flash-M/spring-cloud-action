package top.flashm.springcloud.hystrix.dashborad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class BarryMicroserviceHystrixDashboradApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarryMicroserviceHystrixDashboradApplication.class, args);
	}
}
