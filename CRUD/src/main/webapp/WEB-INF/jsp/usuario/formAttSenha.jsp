<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>
<c:if test="${usuarioLogado.logado2}">
<div class="container" id="tamanho_form2">
<h4>Usuario: ${usuarioLogado.nome}</h4>

	<form action="${linkTo[UsuarioController].updateSenha(null)}"
		method="POST" id="att_usuarioLogado">			
			
			<div class="form-group col-md-6">
			
			<input type="hidden" name="usuario.id" id="id" class="form-control" value="${usuarioLogado.id}"/>
			</div>			
		
			<div class="form-group col-md-6">
			<input type="hidden" name="usuario.nome" id="nome" class="form-control" value="${usuarioLogado.nome}" placeholder="Nome completo"/>
			</div>
			
			<div class="form-group col-md-6">
			<input type="hidden" name="usuario.email" id="email" class="form-control" value="${usuarioLogado.email}" placeholder="Digite um e-mail" />
			</div>

			<div class="form-group col-md-6">
			
			<input type="hidden" name="usuario.login"	id="login" class="form-control" value="${usuarioLogado.login}"/>
			</div>			
		
			<div class="form-group row ">			
			<label for="senhaAtual" >Senha Atual: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</label>
			<div class="col-sm-5">
			<input type="password" name="usuario.senhaAtual" id="senhaAtual" class="form-control" value="${usuario.senhaAtual}"/>
			</div>
				<p id="senhaFalse">${senhaFalse}</p>
			</div>	

			<div class="form-group  row">
				<label for="senha" >Nova Senha: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</label>
					<div class="col-sm-5">
						<input type="password" name="usuario.senha" id="senha" class="form-control" value="${usuario.senha}" />
					</div>
			</div>		
			
			<div class="form-group  row">
				<label for="senhaConf" >Confirmar Nova Senha:</label>
					<div class="col-sm-5">
						<input type="password" name="usuario.senhaConf" id="senhaConf" class="form-control" value="${usuario.senhaConf}" />
					</div>
				<p id="senhaConf" class="mensagens">${senhaConf}</p>
			</div>
			
			<div class="form-group col-md-6">
				<input type=hidden name="usuario.tipoUser" id="tipoUser" class="form-control" value="${usuarioLogado.tipoUser}"/>
			</div>
			  
			 <input type="hidden" name="_method" value="PUT">
			 <input type="hidden" name="usuario.id" value="${usuarioLogado.id}">

		<!-- Modal -->
		<div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Atualizar Senha</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Cancelar">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Deseja realmente atualizar a senha deste usuario ?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							onclick="msg()">Cancelar</button>
						<button type="submit" class="btn btn-primary" onclick="msg()">Confirmar</button>
					</div>
				</div>
			</div>
		</div>

	</form>
	<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#modalExemplo" id="cadastrar">Trocar Senha</button>

</div>	
</c:if>
<c:if test="${!usuarioLogado.logado2}">
	Acesso somente para Administradores
</c:if>

<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>