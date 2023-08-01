package com.jhingan.SpringBootMicroservices;

import com.jhingan.SpringBootMicroservices.dto.Specimen;
import com.jhingan.SpringBootMicroservices.service.ISpecimenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringBootMicroservicesApplicationTests {
	@Autowired
	private ISpecimenService specimenInterface;
	private Specimen specimen;

	@Test
	void contextLoads() {
	}

	@Test
	void fetchSpecimenById_returnsRedBudForID83() {
		givenSpecimenDataAreAvailable();
		whenSearchSpecimenWithID83();
		thenReturnOneEasternRedBudSpecimenForID83();
	}

	private void givenSpecimenDataAreAvailable() {
	}

	private void whenSearchSpecimenWithID83() {

		specimen = specimenInterface.fetchById(83);
	}

	private void thenReturnOneEasternRedBudSpecimenForID83() {
		String description = specimen.getDescription();
		assertEquals("Eastern RedBud", description);
	}

}
