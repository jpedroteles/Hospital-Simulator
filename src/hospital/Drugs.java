package hospital;

import java.util.Map;

public class Drugs {
	private String name;
	private String abrev;
	private String cures;
	private Map<String,String> sideEffects;
	
	public Drugs(String name, String abrev, String cures, Map<String, String> sideEffects){
		this.setName(name);
		this.setAbrev(abrev);
		this.setCures(cures);
		this.setSideEffects(sideEffects);
	}


	/**
	 * @return the name
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
	public Map<String,String> getSideEffects() {
		return sideEffects;
	}

	/**
	 * @param sideEffects the sideEffects to set
	 */
	public void setSideEffects(Map<String,String> sideEffects) {
		this.sideEffects = sideEffects;
	}	


}
