package com.colutti.exploringbasejparepository;

import io.hypersistence.utils.spring.repository.BaseJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
		value = "com.colutti.exploringbasejparepository.repositories",
		repositoryBaseClass = BaseJpaRepositoryImpl.class
)
public class ExploringBaseJpaRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExploringBaseJpaRepositoryApplication.class, args);
	}

}
