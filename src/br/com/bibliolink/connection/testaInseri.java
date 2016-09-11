package br.com.bibliolink.connection;

import java.sql.Connection;

import br.com.bibliolink.model.bean.Aluno;
import br.com.bibliolink.model.dao.AlunoDAO;

public class testaInseri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		aluno.setNome("lucas");
		aluno.setEmail("teste");
		aluno.setEndereco("rua a");
		aluno.setTelefone("88709923");
		Connection connection = new ConnectionFactory().getConnection();

		AlunoDAO dao = new AlunoDAO(connection);
		dao.adicionaAluno(aluno);
		System.out.println("gravado");
	}

}
