package br.com.bibliolink.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bibliolink.model.bean.Autor;

public class AutorDAO {

	private Connection connection;

	public AutorDAO(Connection connection) {
		this.connection = connection;
	}

	public void adicionaAutor(Autor autor) {
		String sql = "insert into autor (nome) values (?)";
		try {

			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, autor.getNome());

			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Autor> listaAutor(){
		String sql = "select * from autor";
		
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<Autor> autores = new ArrayList<Autor>();
			
			while(rs.next()){
				Autor autor = new Autor();
				autor.setId(rs.getLong("id"));
				autor.setNome(rs.getString("nome"));
				
				autores.add(autor);
			}
			pstmt.close();
			rs.close();
			
			return autores;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Autor pesquisaPorId(Long id){
		String sql = "select * from autor";
		
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				if(id == rs.getLong("id")){
					Autor autor = new Autor();
					autor.setId(rs.getLong("id"));
					autor.setNome(rs.getString("nome"));
					
					return autor;
				}
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		return null;
	}
}
