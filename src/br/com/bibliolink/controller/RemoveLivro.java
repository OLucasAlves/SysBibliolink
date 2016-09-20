package br.com.bibliolink.controller;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bibliolink.model.bean.Livro;
import br.com.bibliolink.model.dao.LivroDAO;

public class RemoveLivro implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Livro livro = new Livro();
		
		Connection connection = (Connection) req.getAttribute("conexao");
		
		Long id = Long.parseLong(req.getParameter("id"));
		livro.setId(id);
		
		LivroDAO dao = new LivroDAO(connection);
		dao.removeLivro(livro);
		
		RequestDispatcher rd = req.getRequestDispatcher("sis?acesso=ListaLivro");
		rd.forward(req, res);
		
	}

}
