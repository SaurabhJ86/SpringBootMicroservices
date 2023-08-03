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
	ISpecimenService specimenService;

	private Specimen specimen;

	@Test
	void contextLoads() {
	}

	@Test
	void fetchSpecimenByID_returnsRedbudForID83() {
		givenSpecimenDataIsAvailable();
		whenUserSearchesSpecimenWithID83();
		thenReturnOneEasternRedbudSpecimenForID83();
	}

	private void givenSpecimenDataIsAvailable() {
	}

	private void whenUserSearchesSpecimenWithID83() {
		specimen = specimenService.fetchById(83);
	}

	private void thenReturnOneEasternRedbudSpecimenForID83() {
		String description = specimen.getDescription();
		assertEquals("Eastern Redbud", description);
	}

}
