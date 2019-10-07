package hospital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Patient {

	public String state;

	/**
	 * @param patientState
	 */
	public Patient(String patientState) {
		this.state = patientState;
	}

	/**
	 * @param patient
	 * @return patient state
	 */
	public String getPatientState(Patient patient) {
		return patient.state;
	}

	/**
	 * @param newState
	 */
	public void setPatientState(String newState) {
		state = newState;
	}

	/**
	 * @param drugs
	 */
	public void recieveDrugs(String[] drugs) {		
		checkMixures(drugs);
		if(state != "X") {
			for(int i= 0; i < drugs.length; i++) {
				checkEffect(drugs[i]);
			}
		}
	}

	/**
	 *  Method to used to kill patient with Diabetes
	 */
	public void killDiabetes() {
		if(state == "D") {
			state = "X";
		}
	}

	/**
	 * Check Mixures of drugs and states and changes the result accordingly
	 * Mixures
	 * P + As patient X;
	 * D != I patient X;
	 * I + An, H patient catch F;
	 * 
	 * @param drugs
	 */
	private void checkMixures(String[] drugs) {
		Drugs[] drugsInfo = Utils.loadDrugsInfo();

		for(int i = 0; i <drugs.length; i ++) {
			for(int y = 0; y <drugsInfo.length; y++) {
				if(drugs[i] == drugsInfo[y].getSideEffects().get(0).toString()) {
					if(drugsInfo[y].getSideEffects().get(1).toString() == null) {
						state = drugsInfo[y].getSideEffects().get(2);
					}
					else if (drugsInfo[y].getSideEffects().get(1).toString() == state) {
						state = drugsInfo[y].getSideEffects().get(2);	
					}
					else {
						continue;
					}
				}
				else if (drugsInfo[y].getSideEffects().get(1).toString() == state && drugs[i] == drugsInfo[y].getSideEffects().get(0).toString()) {
					state = drugsInfo[y].getSideEffects().get(2);
				}
				else {
					continue;
				}
			}
		}		
		/*
		List<String> drugsList = new ArrayList<String>();
		drugsList = Arrays.asList(drugs);
		if(drugsList.contains("As") && drugsList.contains("P")) {
			state = "X";
		}
		else if(state.equals("D") && !drugsList.contains("I")) {
			state = "X";
		}
		else if(state.equals("H") &&  drugsList.contains("I") && drugsList.contains("An")){
			state="F";
		}	*/

	}

	/**
	 * 
	 * Rules
	 * As cures F;
	 * An cures T;
	 * I prevents D patient from dying, does not cure D;
	 * P cures F;
	 * @param drug
	 */
	private void checkEffect(String drug) {
		switch(state) {
		case "F":
			if(drug.equals("As") || drug.equals("P")) {
				state = "H";
			}
			break;
		case "T":
			if(drug.equals("An")) {
				state = "H";
			}
			break;
		}
	}

}
