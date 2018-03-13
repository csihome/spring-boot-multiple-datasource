package net.famunity.multidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KeyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeyManagementApplication.class, args);
	}
}
