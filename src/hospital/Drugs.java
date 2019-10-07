package hospital;

import java.util.ArrayList;
import java.util.Map;

public class Drugs {
	private String name;
	private String abrev;
	private String cures;
	private ArrayList<String> sideEffects;
	
	/**
	 * @param name
	 * @param abrev
	 * @param cures
	 * @param sideEffects2
	 */
	public Drugs(String name, String abrev, String cures, ArrayList<String> sideEffects2){
		this.setName(name);
		this.setAbrev(abrev);
		this.setCures(cures);
		this.setSideEffects(sideEffects2);
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the abrev
	 */
	public String getAbrev() {
		return abrev;
	}
	/**
	 * @param abrev the abrev to set
	 */
	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}
	/**
	 * @return the cures
	 */
	public String getCures() {
		return cures;
	}

	/**
	 * @param cures the cures to set
	 */
	public void setCures(String cures) {
		this.cures = cures;
	}

	/**
	 * @return the sideEffects
	 */
	public ArrayList<String> getSideEffects() {
		return sideEffects;
	}

	/**
	 * @param sideEffects2 the sideEffects to set
	 */
	public void setSideEffects(ArrayList<String> sideEffects2) {
		this.sideEffects = sideEffects2;
	}	


}
