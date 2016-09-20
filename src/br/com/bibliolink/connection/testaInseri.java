package br.com.bibliolink.connection;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.bibliolink.model.bean.Livro;

public class testaInseri {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//Aluno aluno = new Aluno();
		/*aluno.setNome("lucas alterado");
		aluno.setEmail("teste alterado");
		aluno.setEndereco("rua alterada");
		aluno.setTelefone("88009756");
		Long matricula = (long) 2;
		aluno.setMatricula(matricula);*/
		
		//Long matricula = (long)2;
		
		Livro livro = new Livro();
		livro.setTitulo("teste");
		
		
		
		Connection connection = new ConnectionFactory().getConnection();

		//AlunoDAO dao = new AlunoDAO(connection);
		//aluno = dao.buscaPorId(matricula);
		
		
		/*List<Aluno> alunos = dao.listaAluno();
		System.out.println("teste");
		for(Aluno aluno : alunos){
			System.out.println("Nome" +aluno.getNome());
			System.out.println("Email" +aluno.getEmail());
			System.out.println("Telefone" +aluno.getTelefone());
			System.out.println("Endereco" +aluno.getEndereco());
		}*/
		
		//dao.alteraAluno(aluno);
		
		//System.out.println("gravado");
	}

}
