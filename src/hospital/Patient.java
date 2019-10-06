package hospital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Patient {

	public String state;

	public Patient(String patientState) {
		this.state = patientState;
	}

	public String getPatientState(Patient patient) {
		return patient.state;
	}

	public void setPatientState(String newState) {
		state = newState;
	}

	public void recieveDrugs(String[] drugs) {
		checkMixures(drugs);
		if(state != "X") {
			for(int i= 0; i < drugs.length; i++) {
				checkEffect(drugs[i]);
			}
		}
	}

	public void killDiabetes() {
		if(state == "D") {
			state = "X";
		}
	}

	/* 
	 * Mixures
	 * P + As patient X;
	 * D != I patient X;
	 * I + An, H patient catch F;
	 */	
	private void checkMixures(String[] drugs) {
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
		}	

	}

	/*
	 * Effects
	 * As cures F;
	 * An cures T;
	 * I prevents D patient from dying, does not cure D;
	 * P cures F;
	 * */
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
