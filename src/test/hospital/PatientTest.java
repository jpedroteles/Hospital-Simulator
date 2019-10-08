package hospital;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PatientTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPatient() {
		Patient fever = new Patient("F");
		assertNotNull(fever);
		Patient diabetes = new Patient("D");
		assertNotNull(diabetes);
		Patient tuberculosis = new Patient("T");
		assertNotNull(tuberculosis);
	}

	@Test
	void testGetPatientState() {
		Patient fever = new Patient("F");
		assertEquals("F", fever.getPatientState());
		Patient diabetes = new Patient("D");
		assertEquals("D", diabetes.getPatientState());
		Patient tuberculosis = new Patient("T");
		assertEquals("T", tuberculosis.getPatientState());
	}

	@Test
	void testSetPatientState() {
		Patient fever = new Patient("F");
		fever.setPatientState("H");
		assertEquals("H",fever.getPatientState());
	}

	@Test
	void testRecieveDrugs() {
		//Check mixture of As with P

		for(int y = 0; y <3 ; y++) {

			//Test As and P
			if(y==0) {
				String[] inputStates = {"F","D","F"};
				String[] availableDrugs = {"As","P","I"};
				Patient[] patients;
				patients = new Patient[inputStates.length];	
				for (int i = 0; i < inputStates.length; i++) {
					patients[i] = new Patient(inputStates[i]);
					patients[i].recieveDrugs(availableDrugs);
				}
				Arrays.fill(inputStates, null);
				Arrays.fill(availableDrugs, null);
				Arrays.fill(patients, null);
			}
			//Test I and As 
			else if (y==1) {
				String[] inputStates = {"F","D","F"};
				String[] availableDrugs = {"As","An"};
				Patient[] patients;
				patients = new Patient[inputStates.length];		
				for (int i = 0; i < inputStates.length; i++) {
					patients[i] = new Patient(inputStates[i]);
					patients[i].recieveDrugs(availableDrugs);
				}
				Arrays.fill(inputStates, null);
				Arrays.fill(availableDrugs, null);
				Arrays.fill(patients, null);
			}
			//Test insulin shortage 
			else {
				String[] inputStates = {"H","D","F","T"};
				String[] availableDrugs = {"An","I"};
				Patient[] patients;
				patients = new Patient[inputStates.length];		
				for (int i = 0; i < inputStates.length; i++) {
					patients[i] = new Patient(inputStates[i]);
					patients[i].recieveDrugs(availableDrugs);
				}
				Arrays.fill(inputStates, null);
				Arrays.fill(availableDrugs, null);
				Arrays.fill(patients, null);
				
			}
		}
	}

	@Test
	void testKillDiabetes() {
		Patient diabetes = new Patient("D");
		diabetes.killDiabetes();
		assertEquals("X", diabetes.getPatientState());
	}

}
