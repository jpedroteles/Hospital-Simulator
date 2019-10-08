package hospital;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void testCreateReport() {
		Map<String,Integer> expected = new HashMap<>();
		expected.put("F", 0);
		expected.put("H", 2);
		expected.put("D", 1);
		expected.put("T", 0);
		expected.put("X", 0);
		
		String availableDrugs = "An,P,I";
		Hospital hospital = new Hospital();
		String inputStates = "F,D,F";
		hospital.createPatients(inputStates);
		hospital.fillFarmacy(availableDrugs);
		hospital.treatmant();
		Map<String,Integer> report = Utils.createReport(hospital.getPatients(), hospital.getAvailableDrugs());
		report.keySet().stream().forEach((key) -> {
	        assertEquals(report.get(key), expected.get(key));
	    });
	}
	
	@Test
	void testSpaghetiMonster() {
		boolean flag = false;
		do {
			Patient death = new Patient("X");
			Utils.spaghettiMonster(death);
			if(death.state.equals("H")) {
				flag = true;
			}
		}while(flag == false);
	}
}
