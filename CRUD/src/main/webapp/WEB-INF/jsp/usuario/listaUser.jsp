<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
<c:if test="${usuarioLogado.logado}">
<div class="table-responsive" id="lista">
	<table id="example" class="display nowrap " style="width: 100%">
		<thead>
			<tr>				
				<th>Tipo de User</th>
				<th>NOME</th>		
				<th>EMAIL</th>				
				<th>Login</th>
				<th>Editar</th>
				<th>Trocar senha</th>				
				<th>Excluir</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>				
				
				<c:if test="${usuario.tipoUser == 1}">
					<td>Admin</td>
				</c:if>
				<c:if test="${usuario.tipoUser != 1 }">
					<td>Comum</td>
				</c:if>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td>${usuario.login}</td>

					<td>
						<form action="<c:url  value='/usuario/formAttUser/${usuario.id}'/>" method="post">
							<input type="hidden" name="_method" value="PUT"> 
							<input type="hidden" name="usuario.id" value="${usuario.id}">
							<input type="submit"value="Editar">
							
						</form>
					</td>
					
					<td>
						<form action="<c:url  value='/usuario/trocaSenha/${usuario.id}'/>" method="post">
							<input type="hidden" name="_method" value="PUT"> 
							<input type="hidden" name="usuario.id" value="${usuario.id}">
							<input type="submit"value="Trocar Senha">
							
						</form>
					</td>
					
					
						<td>
							<form action="<c:url  value='/usuario/remove'/>" method="post">
								<input type="hidden" name="_method" value="DELETE"> 
								<input type="hidden" name="usuario.id" value="${usuario.id}"> 
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
											<h5 class="modal-title" id="exampleModalLabel">Deletar usuario</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Cancelar">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">usuario deletado com sucesso</div>									
										<div class="modal-footer">
											<button type="button" class="btn btn-primary"
												data-dismiss="modal">ok</button>											
										</div>
									</div>
								</div>
							</div>
</c:if>

<c:if test="${!usuarioLogado.logado}">
	Acesso autorizado somente para Administradores
</c:if>
<c:import url="/WEB-INF/jsp/footer.jsp" />