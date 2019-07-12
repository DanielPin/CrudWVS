<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
<div id="lista">
	<table id="example" class="display nowrap">
		<thead>
			<tr>				
				<th>NOME</th>
				<th>CPF</th>			
				<th>EMAIL</th>				
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
			<c:forEach items="${clientes}" var="cliente">
				<tr>					
					<td>${cliente.nome}</td>
					<td>${cliente.cpf}</td>					
					<td>${cliente.email}</td>					
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
							<input type="submit"value="Editar">
							
						</form>
					</td>
					<td>
						<form action="<c:url  value='/cliente/remove'/>" method="post">
							<input type="hidden" name="_method" value="DELETE"> 
							<input type="hidden" name="cliente.id" value="${cliente.id}"> 
							<input	type="submit" value="Excluir" >										
						</form>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	</div>
	<!-- Modal -->
							<div class="modal fade" id="myModal1" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Deletar cliente</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Cancelar">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">Cliente deletado com sucesso</div>									
										<div class="modal-footer">
											<button type="button" class="btn btn-primary"
												data-dismiss="modal">ok</button>											
										</div>
									</div>
								</div>
							</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />