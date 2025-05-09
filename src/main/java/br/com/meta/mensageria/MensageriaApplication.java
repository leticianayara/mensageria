package br.com.meta.mensageria;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableRabbit
@SpringBootApplication(scanBasePackages = "br.com.meta")
@EnableJpaRepositories(basePackages = "br.com.meta.repositories")
@EntityScan(basePackages = "br.com.meta.models")
public class MensageriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensageriaApplication.class, args);
	}

}
