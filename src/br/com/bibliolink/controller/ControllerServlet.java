package br.com.bibliolink.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sis")
public class ControllerServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String parametro = req.getParameter("acesso");
		String nomeDaClasse = "br.com.bibliolink.controller." + parametro;
		
		try{
			Class<?> classe = Class.forName(nomeDaClasse);
			
			Logica logica = (Logica) classe.newInstance();
			logica.executa(req, res);
			
			
		}catch(Exception e){
			throw new ServletException(e);
		}
	}
}
