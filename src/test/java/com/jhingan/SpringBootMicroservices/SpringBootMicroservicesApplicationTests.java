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
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SpringBootMicroservicesApplicationTests {

	@Autowired
	ISpecimenService specimenService;

	private Specimen specimen = new Specimen();

	@MockBean
	private ISpecimenDAO specimenDAO;

	@Test
	void contextLoads() {
	}

	@Test
	void fetchSpecimenByID_returnsRedbudForID83() throws Exception {
		givenSpecimenDataIsAvailable();
		whenUserSearchesSpecimenWithID83();
		thenReturnOneEasternRedbudSpecimenForID83();
	}

	private void givenSpecimenDataIsAvailable() throws Exception {
		Mockito.when(specimenDAO.save(specimen)).thenReturn(specimen);
		specimenService = new SpecimenServiceStub(specimenDAO);
	}

	private void whenUserSearchesSpecimenWithID83() {

		specimen = specimenService.fetchById(83);
	}

	private void thenReturnOneEasternRedbudSpecimenForID83() {
		String description = specimen.getDescription();
		assertEquals("Eastern Redbud", description);
	}

	@Test
	void saveSpecimen_validateReturnSpecimenWithLatAndLong() throws Exception {
		givenSpecimenDataIsAvailable();
		whenUserCreateNewSpecimenAndSaves();
		thenCreateNewSpecimenAndReturnNewSpecimen();
	}

	private void whenUserCreateNewSpecimenAndSaves() {
		specimen.setLatitude("39.74");
		specimen.setLongitude("-84.51");
	}

	private void thenCreateNewSpecimenAndReturnNewSpecimen() throws Exception {

		Specimen newSpecimen = specimenService.save(specimen);
		assertEquals(specimen, newSpecimen);
		verify(specimenDAO, atLeastOnce()).save(specimen);
	}

}
