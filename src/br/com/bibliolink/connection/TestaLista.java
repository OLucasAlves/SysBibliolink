package br.com.bibliolink.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.bibliolink.model.bean.Genero;
import br.com.bibliolink.model.dao.GeneroDAO;

public class TestaLista {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = new ConnectionFactory().getConnection();
		GeneroDAO dao = new GeneroDAO(connection);
		long id = 2;
		
		Genero genero = dao.pesquisaPorId(id);
		System.out.println(""+genero.getId());
		System.out.println(""+genero.getDescricao());
		
		/*List<Genero> generos = dao.listaGenero();
		
		for(Genero genero : generos){
			System.out.println(""+genero.getId());
			System.out.println(""+genero.getDescricao());*/
			/*System.out.println(""+aluno.getEmail());
			System.out.println(""+aluno.getTelefone());
			System.out.println(""+aluno.getEndereco());*/
			System.out.println("-------------------");
		//}
	}

}
