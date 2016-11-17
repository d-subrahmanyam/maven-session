/**
 * 
 */
package com.subbu.translate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.owasp.encoder.Encode;

/**
 * @author subbu
 *
 */
public class TranslatorMainTest {
	
	private ITranslator translator;
	private String input="Hello World";
	
	/**
	 * This unit-test is to test the FrenchTranslator feature
	 */
	@Test
	public void testFrenchTranslator() {
		translator = new FrenchTranslator();
		Result result = translator.translate(Encode.forUriComponent(input));
		Assert.assertEquals("Bonjour Tout Le Monde", result.getText());
	}
	
	/**
	 * This unit-test is to test the GermanTranslator feature
	 */
	@Test
	public void testGermanTranslator() {
		translator = new GermanTranslator();
		Result result = translator.translate(Encode.forUriComponent(input));
		Assert.assertEquals("Hallo Welt", result.getText());
	}
	
	/**
	 * This unit-test is to test the SpanishTranslator feature
	 */
	@Test
	public void testSpanishTranslator() {
		translator = new SpanishTranslator();
		Result result = translator.translate(Encode.forUriComponent(input));
		Assert.assertEquals("Hola Mundo", result.getText());
	}

}
