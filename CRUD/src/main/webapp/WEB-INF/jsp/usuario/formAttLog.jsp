<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>
<c:if test="${usuarioLogado.logado2}">
<div class="container" id="tamanho_form">


	<form action="${linkTo[UsuarioController].updateLog(null)}"
		method="POST" id="att_usuarioLogado">	
		<p class="sucesso" id="suscessoAt">${suscessoAt}</p>
		<p class="sucesso" id="senhaTrue">${senhaTrue}</p>	
		<div class="form-row">
		
		
		
		<div class="form-group col-md-6">
				<label for="id">ID:</label> <input type="text" name="usuario.id" id="id" class="form-control" value="${usuarioLogado.id}" disabled="disabled"/>
			</div>
		
		
			<div class="form-group col-md-6">
				<label for="nome">NOME:</label> <input type="text" name="usuario.nome" id="nome" class="form-control" value="${usuarioLogado.nome}" placeholder="Nome completo"/>
			</div>
			
			<div class="form-group col-md-6">
				<label for="email">E-MAIL:</label> <input type="text" name="usuario.email" id="email" class="form-control" value="${usuarioLogado.email}" placeholder="Digite um e-mail" />
			</div>

			
			<div class="form-group col-md-3">
				<label for="login">Usuario(Login):</label> <input type="text" name="usuario.login"	id="login" class="form-control" value="${usuarioLogado.login}"/>
			<p id="erroAtt">${erroAtt}</p>
			</div>
		

			<div class="form-group col-md-6">
			 <input type="hidden" name="usuario.senha" id="senha" class="form-control" value="${usuarioLogado.senha}" />
			</div>
			
			
			<div class="form-group col-md-6">
				<input type="hidden" name="usuario.tipoUser" id="tipoUser" class="form-control" value="${usuarioLogado.tipoUser}" />
			</div>
			
			
			
			
			
			
			<input type="hidden" name="_method" value="PUT">
			<input type="hidden" name="usuario.id" value="${usuarioLogado.id}">
			
		<!-- Modal -->
		<div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Atualização de informações</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Cancelar">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Deseja realmente atualizar seus dados?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							onclick="msg()">Cancelar</button>
						<button type="submit" class="btn btn-primary" onclick="msg()">Atualizar</button>
					</div>
				</div>
			</div>
		</div>
		</div>
	</form>
	<div class="form-row">		
		<div class="form-group col-md-6">
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalExemplo" id="cadastrar">Atualizar</button>
		</div>
		
		<div class="form-group col-md-6">
			<form action="<c:url  value='/usuario/formAttSenha'/>" method="post">				
				<input  class="btn btn-primary" type="submit"  value=" Trocar Senha"/>			
			</form>
		</div>
	</div>
</div>

	
</c:if>
<c:if test="${!usuarioLogado.logado2}">
	Acesso não autorizado
</c:if>

<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>