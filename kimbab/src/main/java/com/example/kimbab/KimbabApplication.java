package com.example.kimbab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing	//jpa의 동작을 감시하겠다는 설정
public class KimbabApplication {

	public static void main(String[] args) {
		SpringApplication.run(KimbabApplication.class, args);
	}

}
