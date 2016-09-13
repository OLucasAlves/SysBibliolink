package br.com.bibliolink.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bibliolink.model.bean.Aluno;
import br.com.bibliolink.model.dao.AlunoDAO;

public class ListaAluno implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Connection connection = (Connection) req.getAttribute("conexao");
		
		List<Aluno> alunos = new AlunoDAO(connection).listaAluno();
		
		req.setAttribute("alunos", alunos);
		connection.close();
		RequestDispatcher rd = req.getRequestDispatcher("/lista-aluno.jsp");
		rd.forward(req, res);
	}

}
