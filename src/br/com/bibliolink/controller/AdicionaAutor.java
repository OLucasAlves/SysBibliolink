package br.com.bibliolink.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bibliolink.model.bean.Autor;
import br.com.bibliolink.model.dao.AutorDAO;

public class AdicionaAutor implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		Autor autor = new Autor();
		
		Connection connection = (Connection) req.getAttribute("conexao");
		
		autor.setNome(req.getParameter("nome"));
		
		AutorDAO dao = new AutorDAO(connection);
		dao.adicionaAutor(autor);
		
		System.out.println("executando logica");
		return "testa.jsp";
	}

}
