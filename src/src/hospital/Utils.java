package hospital;

import java.util.HashMap;
import java.util.Map;

public class Utils {

	private static Map<String,Integer> statesCounter = new HashMap<>();

	public static Map<String, Integer> createReport(Patient[] patients, String[] availableDrugs) {
		mapStatusCounter();

		for(int i = 0; i < statesCounter.size() ; i++ ) {
			if (availableDrugs == null) {
				for(int y= 0; y < patients.length; y++) {
					patients[y].killDiabetes();
				}
			}

		}
		for(int y= 0; y < patients.length; y++) {
			spaghettiMonster(patients[y]);
			statesCounter.put(patients[y].state, statesCounter.get(patients[y].state)+1);
		}
		return statesCounter;

	}


	public static void mapStatusCounter() {
		statesCounter.put("F", 0);
		statesCounter.put("H", 0);
		statesCounter.put("D", 0);
		statesCounter.put("T", 0);
		statesCounter.put("X", 0);
	}
	

	/* One time in a million the Flying Flying Spaghetti Monster shows his noodly power
	 and resurrects a dead patient (Dead becomes Healthy).*/
	static void spaghettiMonster(Patient patient) {
		double prob = Math.random();
		if(prob <= 0.000001) {
			patient.state = "H";
		}		
	}



}
