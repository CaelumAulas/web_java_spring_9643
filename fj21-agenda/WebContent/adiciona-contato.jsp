<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Contato</title>

<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>

</head>
<body>
	
	<c:import url="cabecalho.jsp"></c:import>

	<form action="adicionaContato" method="post">
	
		<label>Nome:</label>
		<input type="text" name="nome" /><br />
		
		<label>E-mail:</label>
		<input type="text" name="email" /><br />
		
		<label>Endereço:</label>
		<input type="text" name="endereco" /><br />
		
		<caelum:campoData label="Data Nascimento" id="dataNascimento"></caelum:campoData>
		
		<input type="submit" value="Gravar" />
		
	</form>
	
	<c:import url="rodape.jsp"></c:import>
	
</body>
</html>