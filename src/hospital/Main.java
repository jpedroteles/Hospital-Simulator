package hospital;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		Map<String, Integer> report = new HashMap<>();
		
		
		if(args[0] != null) {
			//create patients objects
			hospital.createPatients(args[0]);
		}
		
		if(args[1] != null && args.length >1) {
			//create fill hospital with drugs
			hospital.fillFarmacy(args[1]);
			hospital.treatmant();
			//Final report
			report = Utils.createReport(hospital.getPatients(), hospital.getAvailableDrugs());
		}
		System.out.println(report);
	}

	

}
