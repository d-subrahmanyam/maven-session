package com.subbu.maven.plugins.mybanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.owasp.encoder.Encode;
import org.owasp.encoder.Encoder;

/**
 * Goal which prints a banner
 */
@Mojo(name = "banner", defaultPhase = LifecyclePhase.INITIALIZE)
public class MyBannerMojo extends AbstractMojo {

	/**
	 * This property takes bannerText to be displayed
	 */
	@Parameter(defaultValue = "Hello World", required = true)
	private String bannerText;
	
	
	/**
	 * This property takes the bannerFont to be used to render the ASCII text
	 */
	@Parameter(defaultValue = "graffiti", required = false)
	private BannerFont bannerFont;

	/* (non-Javadoc)
	 * @see org.apache.maven.plugin.AbstractMojo#execute()
	 * In the execute method we make a call to the online heroku service to create an ASCII Text Banner and print the result
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		HttpClient client = new DefaultHttpClient();
		try {
			HttpGet request = new HttpGet("http://artii.herokuapp.com/make?text="+Encode.forUriComponent(bannerText)+"&font="+bannerFont.toString());
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
			String line ="";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println(bannerText);
		//getLog().info(bannerText);
	}
}
