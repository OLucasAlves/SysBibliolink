package br.com.bibliolink.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
