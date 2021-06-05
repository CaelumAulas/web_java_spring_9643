<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Contatos</title>
</head>
<body>

	<c:import url="/cabecalho.jsp"></c:import>

	<table>
		<tr>
			<td>Nome</td>
			<td>Endereço</td>
			<td>E-mail</td>
			<td>Data de Nascimento</td>
			<td>Excluir</td>
		</tr>
		
		<c:forEach items="${contatos}" var="contato">
			<tr>
				<td>${contato.nome}</td>
				<td> ${contato.endereco}</td>
				
				<td>
					<c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a> 
					</c:if>
					
					<c:if test="${empty contato.email}">
						Não informado
					</c:if>
				</td>
				
				<td>
					<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
				</td>
				
				<td>
					<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:import url="/rodape.jsp"></c:import>

</body>
</html>