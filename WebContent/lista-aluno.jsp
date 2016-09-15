<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Lista Alunos</title>
	</head>
	
	<body>
		<p>Teste</p>
		<c:forEach  var="alunos" items="${alunos}">
		   <li>	
				Nome:<c:out value="${alunos.nome}"/>
				Email:<c:out value="${alunos.email}"/>
				Endereço:<c:out value="${alunos.endereco}"/>
				Telefone:<c:out value="${alunos.telefone}"/>
				<a href="sis?acesso=AlteraAluno&paramAltera=popula&matricula=${alunos.matricula}">Alterar</a>
				<a href="sis?acesso=RemoveAluno&matricula=${alunos.matricula}">Remover</a>
			</li>
		</c:forEach>
	</body>
</html>    