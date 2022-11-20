package com.example.demo;

import com.example.demo.model.CurrencyExchangeShort;
import com.example.demo.repository.CurrencyExchangeShortRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableJpaRepositories
@EnableWebMvc
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner initDb(CurrencyExchangeShortRepository repository){
		return args -> {
			repository.saveAll(List.of(
					new CurrencyExchangeShort(1, 40.4748, "AUD"),
					new CurrencyExchangeShort(2, 35.5142, "AZN"),
					new CurrencyExchangeShort(3, 71.1086, "GBP"),
					new CurrencyExchangeShort(4, 15.2772, "AMD"),
					new CurrencyExchangeShort(5, 25.0754, "BYN"),
					new CurrencyExchangeShort(6, 31.853, "BGN"),
					new CurrencyExchangeShort(7, 11.047, "BRL"),
					new CurrencyExchangeShort(8, 15.2691, "HUF"),
					new CurrencyExchangeShort(9, 77.3234, "HKD"),
					new CurrencyExchangeShort(10, 83.7552, "DKK")
					)
			);
		};
	}
}
