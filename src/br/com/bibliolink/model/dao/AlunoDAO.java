package br.com.bibliolink.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Aluno> listaAluno() throws SQLException{
		
		String sql = "select * from aluno";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<Aluno> alunos = new ArrayList<Aluno>();
			
			while(rs.next()){
				Aluno aluno = new Aluno();
				
				aluno.setMatricula(rs.getLong("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setEndereco(rs.getString("endereco"));
				alunos.add(aluno);
			}
			
			rs.close();
			pstmt.close();
			
			return alunos;
		}
	
	
	public void alteraAluno(Aluno aluno){
		String sql = "update aluno set nome=?,email=?,telefone=?,endereco=? where matricula=?";
		
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,aluno.getNome());
			pstmt.setString(2, aluno.getEmail());
			pstmt.setString(3, aluno.getTelefone());
			pstmt.setString(4, aluno.getEndereco());
			pstmt.setLong(5, aluno.getMatricula());
			
			pstmt.execute();
			pstmt.close();
			
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Aluno buscaPorId(Long matricula){
		try{
			PreparedStatement pstmt = connection.prepareStatement("select * from aluno");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if(matricula == rs.getLong("matricula")){
					Aluno aluno = new Aluno();
					aluno.setMatricula(rs.getLong("matricula"));
					aluno.setNome(rs.getString("nome"));
					aluno.setEmail(rs.getString("email"));
					aluno.setTelefone(rs.getString("telefone"));
					aluno.setEndereco(rs.getString("endereco"));
					return aluno;
				}
				
			}
			return null;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
