package mingsuu.ColPoP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableConfigurationProperties
@EnableCaching
@ConfigurationPropertiesScan
@EnableJpaRepositories
@EnableWebMvc
public class ColPoPApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColPoPApplication.class, args);
	}

}

