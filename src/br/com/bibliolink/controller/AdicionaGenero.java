package br.com.bibliolink.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bibliolink.model.bean.Genero;
import br.com.bibliolink.model.dao.GeneroDAO;

public class AdicionaGenero implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		Genero genero = new Genero();
		
		Connection connection = (Connection) req.getAttribute("conexao");
		
		genero.setDescricao(req.getParameter("descricao"));
		
		GeneroDAO dao = new GeneroDAO(connection);
		dao.adicionaGenero(genero);
		
		System.out.println("executando logica");
		return "testa.jsp";
	}

}
