<html>
	<head>
		<title>Adicionar Livro</title>
	</head>
	
	<body>
		<form action="sis" method="POST">
			<label for="titulo">Titulo</label>
			<input type="text" id="titulo" name="titulo"><br/>
			<label for="autor">Autor</label>
			<input type="text" id="autor" name="autor"><br/>
			<label for="genero">Genero</label>
			<input type="text" id="genero" name="genero"><br/>
	
			<input type="hidden" name="acesso" value="AdicionaLivro" /> <br/>
			<input type="submit" value="Adicionar">
			
		</form>
	</body>
</html>