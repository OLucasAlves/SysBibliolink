package br.com.bibliolink.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import br.com.bibliolink.model.bean.Aluno;
import br.com.bibliolink.model.dao.AlunoDAO;

public class AdicionaAluno implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		Aluno aluno = new Aluno();
		Connection connection = (Connection) req.getAttribute("conexao");
		
		aluno.setNome(req.getParameter("nome"));
		aluno.setEmail(req.getParameter("email"));
		aluno.setEndereco(req.getParameter("endereco"));
		aluno.setTelefone(req.getParameter("telefone"));
		
		AlunoDAO dao = new AlunoDAO(connection);
		dao.adicionaAluno(aluno);
		
		System.out.println("executando logica");
		
		RequestDispatcher rd = req.getRequestDispatcher("/lista.jsp");
		rd.forward(req, res);
		
	}
}
