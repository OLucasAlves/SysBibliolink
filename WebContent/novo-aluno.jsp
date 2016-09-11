<html>
	<head>
		<title>Adicionar Aluno</title>
	</head>
	
	<body>
		<form action="sis" method="POST">
			<label for="nome">Nome</label>
			<input type="text" id="nome" name="nome"><br/>
			<label for="email">Email</label>
			<input type="text" id="email" name="email"><br/>
			<label for="endereco">Endereço</label>
			<input type="text" id="endereco" name="endereco"><br/>
			<label for="telefone">Telefone</label>
			<input type="text" id="telefone" name="telefone"><br/>
			<input type="hidden" name="acesso" value="AdicionaAluno" /> <br/>
			<input type="submit" value="Adicionar">
			
		</form>
	</body>
</html>