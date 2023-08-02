package com.jhingan.SpringBootMicroservices;

import com.jhingan.SpringBootMicroservices.dao.ISpecimenDAO;
import com.jhingan.SpringBootMicroservices.dto.Specimen;
import com.jhingan.SpringBootMicroservices.service.ISpecimenService;
import com.jhingan.SpringBootMicroservices.service.SpecimenServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringBootMicroservicesApplicationTests {
//	@Autowired
	private ISpecimenService specimenService;
	private Specimen specimen;

	@MockBean
	private ISpecimenDAO specimenDAO;

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
		Mockito.when(specimenDAO.save(specimen)).thenReturn(specimen);
		specimenService = new SpecimenServiceStub(specimenDAO);
	}

	private void whenSearchSpecimenWithID83() {

		specimen = specimenService.fetchById(83);
	}

	private void thenReturnOneEasternRedBudSpecimenForID83() {
		String description = specimen.getDescription();
		assertEquals("Eastern RedBud", description);
	}

	@Test
	void saveSpecimen_validateReturnSpecimenWithLatitudeAndLongitude() {
		givenSpecimenDataAreAvailable();
		whenUserCreatesANewSpecimenAndSaves();
		thenCreateNewSpecimenAndReturnIt();
	}

	private void whenUserCreatesANewSpecimenAndSaves() {
		specimen.setLatitude("39.74");
		specimen.setLongitude("-84.51");
	}

	private void thenCreateNewSpecimenAndReturnIt() {
		Specimen createdSpecimen = specimenService.save(specimen);
		assertEquals(specimen, createdSpecimen);
	}

}
