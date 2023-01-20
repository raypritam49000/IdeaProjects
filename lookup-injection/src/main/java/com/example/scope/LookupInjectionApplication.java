package com.example.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class LookupInjectionApplication {

	@Autowired
	private UserService userService;

	@GetMapping("/scope")
	public List<String> getWeatherForecast() throws InterruptedException {
		String response1 = userService.getCurrentTempFromWeatherAPI();//2022-07-29T13:42:25.982->57
		Thread.sleep(1000);
		String response2 = userService.getCurrentTempFromWeatherAPI();//2022-07-29T13:43:25.982->57
		return Arrays.asList(response1,response2);
	}

	public static void main(String[] args) {
		SpringApplication.run(LookupInjectionApplication.class, args);
	}

}
