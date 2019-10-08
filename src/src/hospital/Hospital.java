package hospital;

public class Hospital {
	private String[] availableDrugs;
	private Patient[] patients;
	
	public String[] getAvailableDrugs() {
		return availableDrugs;
	}

	public Patient[] getPatients() {
		return patients;
	}

	public void fillFarmacy(String drugs) {
		availableDrugs = drugs.split(",");		
	}

	public void treatmant() {
		for(int i = 0; i < patients.length; i++) {
			patients[i].recieveDrugs(availableDrugs);
		}		
	}

	public void createPatients(String states) {
		String[] inputStates = states.split(",");
		patients = new Patient[inputStates.length];
		
		for (int i = 0; i < inputStates.length; i++) {
			patients[i] = new Patient(inputStates[i]);
		}		
	}

}
