package pl.piomin.services.order;

//import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

import pl.piomin.services.order.repository.OrderRepository;
 

@SpringBootApplication
@RibbonClients({
	@RibbonClient(name = "account-service"),
	@RibbonClient(name = "customer-service"),
	@RibbonClient(name = "product-service")
})
@EnableDiscoveryClient
@EnableCaching
@EnableHystrix
public class OrderApplication {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
//		new SpringApplicationBuilder(OrderApplication.class).web(WebApplicationType.SERVLET).run(args);
		new SpringApplicationBuilder(OrderApplication.class).web(true).run(args);
	}
	
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("customers");
	}
	
	@Bean
	public OrderRepository repository() {
		return new OrderRepository();
	}
//	@Bean(name = "hystrixRegistrationBean")
//	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
//		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//		ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(
//				streamServlet);
//		registrationBean.setLoadOnStartup(1);
//		registrationBean.addUrlMappings("/hystrix.stream");
//		registrationBean.setName("HystrixMetricsStreamServlet");
//		return registrationBean;
//	} 
//	@Bean(name = "hystrixRegistrationBean")
//	public ServletRegistrationBean getServlet() {
//		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//		ServletRegistrationBean registrationBean = new ServletRegistrationBean (
//				streamServlet);
//		registrationBean.setLoadOnStartup(1);
//		registrationBean.addUrlMappings("/hystrix.stream");
//		registrationBean.setName("HystrixMetricsStreamServlet");
//		return registrationBean;
//	} 
}
