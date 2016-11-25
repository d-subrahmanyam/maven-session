/**
 * 
 */
package com.subbu.translate.library;

/**
 * @author devsu04
 *
 */
public enum Language {
	
	FRENCH ("FRENCH"),
	GERMAN ("GERMAN"),
	SPANISH ("SPANISH");
	
	private String value;
	
	private Language(String value) {
		this.setValue(value);
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
