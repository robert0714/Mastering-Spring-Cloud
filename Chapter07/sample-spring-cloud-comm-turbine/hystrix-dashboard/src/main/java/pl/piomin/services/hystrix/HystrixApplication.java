package pl.piomin.services.hystrix;

//import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class HystrixApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(HystrixApplication.class).web(true).run(args);
//		new SpringApplicationBuilder(HystrixApplication.class).web(WebApplicationType.SERVLET).run(args);
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
