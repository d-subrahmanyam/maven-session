/**
 * 
 */
package com.subbu.translate.library;

/**
 * @author devsu04
 *
 */
public class TranslatorFactory {
	
	public static ITranslator getTranslator(Language language) {
		ITranslator translator = null;
		switch(language) {
		case FRENCH:
			translator = new FrenchTranslator();
			break;
		case GERMAN:
			translator = new GermanTranslator();
			break;
		case SPANISH:
			translator = new SpanishTranslator();
			break;
		}
		return translator;
	}

}
