<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Lista livros</title>
	</head>
	
	<body>
		<c:forEach var="livros" items="${livros}">
			<li>
				Titulo:<c:out value="${livros.titulo}"></c:out>
				Autor:<c:out value="${livros.autor}"></c:out>
				Genero:<c:out value="${livros.genero}"></c:out>
				<a href="sis?acesso=RemoveLivro&id=${livros.id}">Remover</a>
				<a href="sis?acesso=AlteraLivro&paramAltera=popula&id=${livros.id}">Altera</a>
			</li>
		</c:forEach>
	</body>
</html>