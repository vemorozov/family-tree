package com.example.familytree;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.familytree.controllers.PersonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FamilyTreeApplicationTests {

	@Autowired
	private PersonController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
