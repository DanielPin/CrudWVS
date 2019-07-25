<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>
<c:if test="${usuarioLogado.logado}">
<div id="tamanho_form">


	<form action="${linkTo[UsuarioController].adiciona(null) }"
		method="POST" id="cad_usuario">

		
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="nome">NOME:</label>
				<input type="text" name="usuario.nome" id="nome" class="form-control" value="${usuario.nome}" placeholder="Nome completo"/>
			</div>
			
			<div class="form-group col-md-6">
				<label for="email">E-MAIL:</label>
				<input type="text" name="usuario.email" id="email" class="form-control" value="${usuario.email}" placeholder="Digite um e-mail" />
			</div>

			<div class="form-group col-md-6">
				<label for="login">Usuario(Login):</label>
				<input type="text" name="usuario.login"	id="login" class="form-control" value="${usuario.login}"/>
				<p id="login">${login}</p>
			</div>

			<div class="form-group col-md-6">
				<label for="senha">Senha:</label>
				<input type="password" name="usuario.senha" id="senha" class="form-control" value="${usuario.senha}" />
			</div>
			
			<div class="form-group">
			    <label for="tipoUser">Tipo de usuario</label>
			    <select class="form-control" id="tipoUser"  name="usuario.tipoUser">
			      <option value = 0>COMUM</option>
			      <option value = 1>ADMIN</option>			     
			    </select>
			  </div>		

		<!-- Modal -->
		<div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Cadastro de acesso usuario</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Cancelar">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Deseja realmente cadastrar um novo usuario ?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							onclick="msg()">Cancelar</button>
						<button type="submit" class="btn btn-primary" onclick="msg()">Confirmar</button>
					</div>
				</div>
			</div>
		</div>
		</div>
	</form>
<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#modalExemplo" id="cadastrar">Cadastrar</button>
</div>

	
</c:if>
<c:if test="${!usuarioLogado.logado}">
	Acesso somente para Administradores
</c:if>

<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>