package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("----------------");

		var objectMapper = new ObjectMapper();

		var user = new User("김우중", 24, "010-6773-0139");

		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);

		var objectUser = objectMapper.readValue(text, User.class);

		System.out.println(objectUser);
	}

}
