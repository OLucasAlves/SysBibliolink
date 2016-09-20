package br.com.bibliolink.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Genero> listaGenero(){
		String sql = "select * from genero";
		
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<Genero> generos = new ArrayList<Genero>();
			
			while(rs.next()){
				Genero genero = new Genero();
				genero.setId(rs.getLong("id"));
				genero.setDescricao(rs.getString("descricao"));
				
				generos.add(genero);
			}
			pstmt.close();
			rs.close();
			
			return generos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Genero pesquisaPorId(Long id){
		String sql = "select * from genero";
		
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				if(id == rs.getLong("id")){
					Genero genero = new Genero();
					genero.setId(rs.getLong("id"));
					genero.setDescricao(rs.getString("descricao"));
					
					return genero;
				}
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		return null;
	}
	
}
















