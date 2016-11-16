/**
 * 
 */
package com.subbu.translate;

import org.owasp.encoder.Encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author subbu
 *
 */
public class TranslatorMain {
	
	private static final Logger logger = LoggerFactory.getLogger(TranslatorMain.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ITranslator translator = new FrenchTranslator();
		//ITranslator translator = new GermanTranslator();
		ITranslator translator = new SpanishTranslator();
		Result result = translator.translate(Encode.forUriComponent("Hello World"));
		logger.info("Hello World - {}", result.getText());
	}

}
