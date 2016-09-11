package br.com.bibliolink.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.bibliolink.model.bean.Aluno;

public class AlunoDAO {
	
	private Connection connection;
	
	public AlunoDAO(Connection connection){
		this.connection = connection;
	}
	
	public void adicionaAluno(Aluno aluno){
		String sql = "insert into aluno (nome,email,telefone,endereco) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1,aluno.getNome());
			pstmt.setString(2, aluno.getEmail());
			pstmt.setString(3, aluno.getEndereco());
			pstmt.setString(4, aluno.getTelefone());
			
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
