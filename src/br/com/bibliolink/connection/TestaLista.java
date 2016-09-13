package br.com.bibliolink.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.bibliolink.model.bean.Aluno;
import br.com.bibliolink.model.dao.AlunoDAO;

public class TestaLista {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = new ConnectionFactory().getConnection();
		AlunoDAO dao = new AlunoDAO(connection);
		List<Aluno> alunos = dao.listaAluno();
		
		for(Aluno aluno : alunos){
			System.out.println(""+aluno.getNome());
			System.out.println(""+aluno.getEmail());
			System.out.println(""+aluno.getTelefone());
			System.out.println(""+aluno.getEndereco());
			System.out.println("-------------------");
		}
	}

}
