<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <html>
    	<head>
    		<title>Altera aluno</title>
    	</head>
    	
    	<body>
    		<form action="sis" method="POST">
    			Nome:<input type="text" name="nome" value="${requestScope.nome}"><br/>
    			Email:<input type="text" name="email" value="${requestScope.email}"><br/>
    			Endereco:<input type="text" name="endereco" value="${requestScope.endereco}"><br/>
    			Telefone:<input type="text" name="telefone" value="${requestScope.telefone}"><br/>
    			<input type="hidden" name="matricula" value="${param.matricula}"><br/>
    			<input type="hidden" name="acesso" value="AlteraAluno">
    			<input type="hidden" name="paramAltera" value="altera">
    			
    			<input type="submit" value="Alterar">
    		</form>
    	</body>
    </html>