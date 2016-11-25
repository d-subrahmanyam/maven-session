/**
 * 
 */
package com.subbu.translate.library;

/**
 * @author subbu
 *
 */
public class Result {
	
	/**
	 * Holds the http code
	 */
	private String code;
	
	/**
	 * Holds the lang for translation
	 */
	private String lang;
	
	/**
	 * Holds the resulting text
	 */
	private String[] text;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		StringBuilder _result = new StringBuilder();
		for(String word:text) {_result.append(word); }
		return _result.toString();
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String[] text) {
		this.text = text;
	}

}
