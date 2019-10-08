/**
 * 
 */
package hospital;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Pedro Teles
 *
 */
class HospitalTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFillFarmacy() {
		String availableDrugs = "As,P,I";
		Hospital hospital = new Hospital();
		hospital.fillFarmacy(availableDrugs);
		String[] expectedDrugs = {"As","P","I"};
		assertArrayEquals(expectedDrugs,hospital.getAvailableDrugs());

	}

	@Test
	void testTreatmant() {

		String availableDrugs = "As,P,I";
		Hospital hospital = new Hospital();
		String inputStates = "F,D,F";
		hospital.createPatients(inputStates);
		hospital.fillFarmacy(availableDrugs);
		hospital.treatmant();
		for(int i = 0; i < hospital.getPatients().length; i++) {
			assertEquals("X",hospital.getPatients()[i].state);		
		}

	}

	@Test
	void testCreatePatients() {
		Hospital hospital = new Hospital();
		String inputStates = "T,D,F";
		hospital.createPatients(inputStates);
		hospital.getPatients();
		assertNotNull(hospital);
	}

}
