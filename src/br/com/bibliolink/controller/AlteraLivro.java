package br.com.bibliolink.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bibliolink.model.bean.Livro;
import br.com.bibliolink.model.dao.LivroDAO;

public class AlteraLivro implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String tipo = req.getParameter("paramAltera");
		if(tipo.equals("altera")){
			this.alteraLivro(req, res);
		}else{
			this.popula(req, res);
		}
		
	}
	
	public void popula(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		Livro livro = new Livro();
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		Connection connection = (Connection) req.getAttribute("conexao");

		LivroDAO dao = new LivroDAO(connection);
		livro = dao.pesquisaPorId(id);
		
		req.setAttribute("titulo", livro.getTitulo());
		req.setAttribute("autor", livro.getAutor());
		req.setAttribute("genero", livro.getGenero());
		
		RequestDispatcher rd = req.getRequestDispatcher("/altera-livro.jsp");
		rd.forward(req, res);
	}
	
	public void alteraLivro(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		Livro livro = new Livro();
		
		Connection connection = (Connection) req.getAttribute("conexao");
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		livro.setId(id);
		livro.setTitulo(req.getParameter("titulo"));
		livro.setAutor(req.getParameter("autor"));
		livro.setGenero(req.getParameter("genero"));
		
		LivroDAO dao = new LivroDAO(connection);
		dao.alteraLivro(livro);
		
		RequestDispatcher rd = req.getRequestDispatcher("sis?acesso=ListaLivro");
		rd.forward(req, res);
	}

}
