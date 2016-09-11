package br.com.bibliolink.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.bibliolink.model.bean.Genero;

public class GeneroDAO {
	
	private Connection connection;
	
	public GeneroDAO(Connection connection){
		this.connection = connection;
	}
	
	public void adicionaGenero(Genero genero){
		String sql = "insert into genero (descricao) values (?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, genero.getDescricao());
			
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e); 
		}
	}
}
