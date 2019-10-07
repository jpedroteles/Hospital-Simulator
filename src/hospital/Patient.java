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
				if(drugs[i].toString().equals(drugsInfo[y].getSideEffects().get(0).toString())) {
					if(state.equals(drugsInfo[y].getSideEffects().get(1))) {
						state = drugsInfo[y].getSideEffects().get(2).toString();
					}
					else  {
						state = drugsInfo[y].getSideEffects().get(2).toString();
					}
				}
				else if (drugs[i].toString().equals(drugsInfo[y].getAbrev()) && state.equals(drugsInfo[y].getCures())) {
					state = "H";
				}
				else {
					killDiabetes();
				}
			}
		}
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