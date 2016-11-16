/**
 * 
 */
package com.subbu.translate;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author subbu
 *
 */
public class GermanTranslator implements ITranslator {

	/* (non-Javadoc)
	 * @see com.subbu.translate.Translater#translate(com.subbu.translate.Result)
	 */
	@Override
	public Result translate(String input) {
		StringBuffer result = new StringBuffer();
		Result jsonResult = null;
		HttpClient client = new DefaultHttpClient();
		try {
			HttpGet request = new HttpGet("https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20161116T183928Z.4a55bfb275da42ee.2acf744993f12aa9b8663c1ceb15475d3ca5ad4f&lang=en-de&text="+input);
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
			String line ="";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			jsonResult = gson.fromJson(result.toString(), Result.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jsonResult;
	}

}
