package com.subbu.translate.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owasp.encoder.Encode;

import com.subbu.translate.library.ITranslator;
import com.subbu.translate.library.Language;
import com.subbu.translate.library.TranslatorFactory;

/**
 * Servlet implementation class TranslateServlet
 */
public class TranslateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TranslateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	/**
	 * This is a utility method that performs the translation
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("inputText");
		input = Encode.forUriComponent(input);
		System.out.println("inputText - " + input);
		String language = request.getParameter("lang");
		System.out.println("language - " + language);
		ITranslator translator = TranslatorFactory.getTranslator(Language.valueOf(language.toUpperCase()));
		String result = translator.translate(input).getText();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

}
