package br.com.bibliolink.controller;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bibliolink.model.bean.Aluno;
import br.com.bibliolink.model.dao.AlunoDAO;

public class RemoveAluno implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Aluno aluno = new Aluno();
		
		Connection connection = (Connection) req.getAttribute("conexao");
		
		Long matricula = Long.parseLong(req.getParameter("matricula"));
		aluno.setMatricula(matricula);
		
		AlunoDAO dao = new AlunoDAO(connection);
		dao.remover(aluno);
		
		RequestDispatcher rd = req.getRequestDispatcher("sis?acesso=ListaAluno");
		rd.forward(req, res);
	}

}
