package hospital;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.*;

public class Utils {

	private static Map<String,Integer> statesCounter = new HashMap<>();
	public static Drugs[] drugsInfo;

	/**
	 * Create final report with the final patient states
	 * 
	 * @param patients
	 * @param availableDrugs
	 * @return statesCounter 
	 */
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



	/**
	 * One time in a million the Flying Flying Spaghetti Monster shows his noodly power
	 and resurrects a dead patient (Dead becomes Healthy).
	 * @param patient
	 */
	private static void spaghettiMonster(Patient patient) {
		double prob = Math.random();
		if(prob <= 0.000001) {
			patient.state = "H";
		}		
	}

	/**
	 * 
	 */
	public static Drugs[] loadDrugsInfo() {
		String jsonData = readFile("D:/User/Documents/GitHub/Hospital-Simulator/Hospital-simulator/hospital-simulator/resources/Drugs.txt");
		JSONObject jobj = new JSONObject(jsonData);
		JSONArray jarr = new JSONArray(jobj.getJSONArray("Drugs").toString());
		drugsInfo = new Drugs[jarr.length()];

		for(int i =0; i < jarr.length(); i++) {	           
			String name = jarr.getJSONObject(i).getString("name");
			String id = jarr.getJSONObject(i).getString("short");
			String cures = jarr.getJSONObject(i).getString("cures");
			String drug, previous,newStatus;

			JSONArray sideEffectsArr = new JSONArray(jarr.getJSONObject(i).getJSONArray("sideEffects").toString());
			for (int y = 0; y <sideEffectsArr.length(); y ++) {
				drug = new String(sideEffectsArr.getJSONObject(y).getString("drug"));
				previous = new String(sideEffectsArr.getJSONObject(y).getString("previous"));
				newStatus = new String(sideEffectsArr.getJSONObject(y).getString("new"));
				ArrayList<String> sideEffectsTemp = new ArrayList<String>();
				sideEffectsTemp.add(drug);
				sideEffectsTemp.add(previous);
				sideEffectsTemp.add(newStatus);
				Drugs drug1 = new Drugs(name,id,cures,sideEffectsTemp);
				drugsInfo[i] = drug1;
				break;
			}			
		}
		return drugsInfo;
	}


	/**
	 * Reads content of file
	 * @param string
	 * @return content of file
	 */
	private static String readFile(String string) {
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(string));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


}