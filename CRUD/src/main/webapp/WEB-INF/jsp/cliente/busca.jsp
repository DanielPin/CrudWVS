<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<div id="tamanho_lista">
<a class="btn btn-secondary btn-lg" href="${linkTo[ClienteController].form()}">Novo cliente</a>

<table class="table table-hover">
    <thead>
        <tr>
				<th>ID</th>
				<th>NOME</th>
				<th>CPF</th>
				<th>RG</th>
				<th>EMAIL</th>
				<th>TELEFONE</th>
				<th>CELULAR</th>
				<th>RUA</th>
				<th>BAIRRO</th>
				<th>CEP</th>
				<th>CIDADE</th>
				<th>ESTADO</th>
				<th>Editar</th>
				<th>Excluir</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${clienteList}" var="cliente">
            <tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.cpf}</td>
					<td>${cliente.rg}</td>
					<td>${cliente.email}</td>
					<td>${cliente.telefone}</td>
					<td>${cliente.celular}</td>
					<td>${cliente.rua}</td>
					<td>${cliente.bairro}</td>
					<td>${cliente.cep}</td>
					<td>${cliente.cidade}</td>
					<td>${cliente.estado}</td>
					<td>
						<form action="<c:url  value='/cliente/form_att/${cliente.id}'/>" method="post">
							<input type="hidden" name="_method" value="PUT"> 
							<input type="hidden" name="cliente.id" value="${cliente.id}">
							<input type="submit" class="btn btn-primary" value="Editar">
						</form>
					</td>
					<td>
						<form action="<c:url  value='/cliente/remove'/>" method="post">
							<input type="hidden" name="_method" value="DELETE"> 
							<input type="hidden" name="cliente.id" value="${cliente.id}"> 
						    <input	type="submit" value="Excluir" class="btn btn-primary">						
						
						</form>
					</td>

				</tr>
        </c:forEach>
    </tbody>
</table>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>