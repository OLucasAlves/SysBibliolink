<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Altera Livro</title>
</head>

<body>
	<form action="sis" method="POST">
		Titulo<input type="text" name="titulo" value="${requestScope.titulo}"><br/>
		Autor<input type="text" name="autor" value="${requestScope.autor}" ><br/>
		Genero<input type="text" name="genero" value="${requestScope.genero}" ><br/>
		<input type="hidden" name="id" value="${param.id}"> 
		<input type="hidden" name="acesso" value="AlteraLivro"> 
		<input type="hidden" name="paramAltera" value="altera">
		
		<input type="submit" value="Alterar"> 
	</form>
</body>
</html>
