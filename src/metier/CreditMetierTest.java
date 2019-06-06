package metier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CreditMetierTest {
	
	private ICreditMetier metier;

	@Before
	public void setUp() throws Exception {
		metier = new CreditMetier();
	}

	@Test
	public void testCalculerMensualiteCredit() {
		double capital = 200000;
		int duree = 240;
		double taux = 4.5;
		
		double resultatAttendu = 1265.2987;
		
		double resultatCalculer = metier.calculerMensualiteCredit(capital, taux, duree);
		
		assertEquals(resultatAttendu, resultatCalculer, 0.0001);
	}

}
