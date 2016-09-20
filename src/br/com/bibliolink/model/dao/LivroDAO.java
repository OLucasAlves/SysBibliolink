package br.com.bibliolink.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bibliolink.model.bean.Livro;

public class LivroDAO {
	
	private Connection connection;
	
	public LivroDAO(Connection connection){
		this.connection = connection;
	}
	
	public void adicionaLivro(Livro livro){
		String sql = "insert into livro (titulo,autor,genero) values (?,?,?)";
		
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, livro.getTitulo());
			pstmt.setString(2,livro.getAutor());
			pstmt.setString(3, livro.getGenero());
			
			pstmt.execute();
			pstmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Livro> listaLivro(){
		String sql = "select * from livro";
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<Livro> livros = new ArrayList<Livro>();
			
			while(rs.next()){
				Livro livro = new Livro();
				
				livro.setId(rs.getLong("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setGenero(rs.getString("genero"));
				
				livros.add(livro);
			}
			
			pstmt.close();
			rs.close();
			
			return livros;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void alteraLivro(Livro livro){
		String sql = "update livro set titulo=?,autor=?,genero=? where id = ?";
		
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, livro.getTitulo());
			pstmt.setString(2, livro.getAutor());
			pstmt.setString(3, livro.getGenero());
			pstmt.setLong(4, livro.getId());
			
			pstmt.execute();
			pstmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void removeLivro(Livro livro){
		String sql = "delete from livro where id = ?";
		
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1,livro.getId());
			
			pstmt.execute();
			pstmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Livro pesquisaPorId(Long id){
		String sql = "select * from livro";
		
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				if(id == rs.getLong("id")){
					Livro livro = new Livro();
					livro.setId(rs.getLong("id"));
					livro.setTitulo(rs.getString("titulo"));
					livro.setAutor(rs.getString("autor"));
					livro.setGenero(rs.getString("genero"));
					
					return livro;
				}
			}
			return null;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}
