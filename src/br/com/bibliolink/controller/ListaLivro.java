package br.com.bibliolink.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bibliolink.model.bean.Livro;
import br.com.bibliolink.model.dao.LivroDAO;

public class ListaLivro implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Connection connection = (Connection) req.getAttribute("conexao");
		
		List<Livro> livros = new LivroDAO(connection).listaLivro();
		req.setAttribute("livros", livros);
		connection.close();
		RequestDispatcher rd = req.getRequestDispatcher("/lista-livro.jsp");
		rd.forward(req, res);
	}
	
}
