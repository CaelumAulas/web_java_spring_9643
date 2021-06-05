<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*,
				 br.com.caelum.agenda.modelo.*,
				 br.com.caelum.agenda.dao.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Contatos</title>
</head>
<body>

	<% 
		List<Contato> contatos = new ArrayList<>();
		ContatoDao dao = new ContatoDao();
		contatos = dao.getLista();
	%>
	
	<table>
		<tr>
			<td>Nome</td>
			<td>Endereço</td>
			<td>E-mail</td>
			<td>Data de Nascimento</td>
		</tr>
		
		<%
			for(Contato contato : contatos){
		%>
		<tr>
			<td><%= contato.getNome() %></td>
			<td><%= contato.getEndereco() %></td>
			<td><%= contato.getEmail() %></td>
			<td><%= contato.getDataNascimento().getTime() %></td>
		</tr>
		<% } %>

	</table>

</body>
</html>