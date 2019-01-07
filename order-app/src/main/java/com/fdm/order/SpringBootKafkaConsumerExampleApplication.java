package com.fdm.order;

import com.fdm.order.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class SpringBootKafkaConsumerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaConsumerExampleApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean(name = "bean1")
	public Order getOrder(){
		return new Order(1L);
	}

	@Bean(name = "bean2")
	public Order getOrder2(){
		return new Order(2L);
	}
}
