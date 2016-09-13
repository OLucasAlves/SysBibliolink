package br.com.bibliolink.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bibliolink.model.bean.Aluno;
import br.com.bibliolink.model.dao.AlunoDAO;

public class AlteraAluno implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String tipo = req.getParameter("paramAltera");
		if(tipo.equals("altera")){
			this.altera(req, res);
		}else{
			this.popula(req, res);
		}
	}
	
	public void popula(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		Aluno aluno = new Aluno();
		long matricula = Long.parseLong(req.getParameter("matricula"));
		
		Connection connection = (Connection) req.getAttribute("conexao");
		
		AlunoDAO dao = new AlunoDAO(connection);
		aluno = dao.buscaPorId(matricula);
		
		req.setAttribute("nome", aluno.getNome());
		req.setAttribute("email", aluno.getEmail());
		req.setAttribute("endereco", aluno.getEndereco());
		req.setAttribute("telefone", aluno.getTelefone());
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/altera-aluno.jsp");
		rd.forward(req, res);
	}

	public void altera(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		Aluno aluno = new Aluno();
		long matricula = Long.parseLong(req.getParameter("matricula"));
		
		aluno.setMatricula(matricula);
		aluno.setNome(req.getParameter("nome"));
		aluno.setEmail(req.getParameter("email"));
		aluno.setEndereco(req.getParameter("endereco"));
		aluno.setTelefone(req.getParameter("telefone"));
		
		Connection connection = (Connection) req.getAttribute("conexao");
		
		AlunoDAO dao = new AlunoDAO(connection);
		dao.alteraAluno(aluno);
		
		RequestDispatcher rd = req.getRequestDispatcher("sis?acesso=ListaAluno");
		rd.forward(req, res);
	}
}
