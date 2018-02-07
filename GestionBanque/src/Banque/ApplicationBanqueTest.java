package Banque;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ApplicationBanqueTest {

	@Test
	void testCreationCompte() {
		ApplicationBanque bank = new ApplicationBanque();
		bank.creerCompteClient(1, 1, "Altine", 5f, 400000f);
		assertNotEquals(0,bank.nombreDeClient());	
	}

}
