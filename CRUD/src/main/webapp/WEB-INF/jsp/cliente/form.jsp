<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

<div id="tamanho_form">


	<form action="${linkTo[ClienteController].adiciona(null) }"
		method="POST" id="cad_cliente">


		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="nome">NOME:</label> <input type="text" name="cliente.nome" id="nome" class="form-control" value="${cliente.nome}" placeholder="Nome completo" />
			</div>

			<div class="form-group col-md-6">
				<label for="cpf">CPF:</label> <input type="text" name="cliente.cpf"	id="cpf" class="form-control" value="${cliente.cpf}" placeholder="000.000.000-00" />
			</div>

			<div class="form-group col-md-6">
				<label for="rg">RG:</label> <input type="text" name="cliente.rg" id="rg" class="form-control" value="${cliente.rg}"	placeholder="00.000.000-0" />
			</div>

			<div class="form-group col-md-6">
				<label for="email">E-MAIL:</label> <input type="text" name="cliente.email" id="email" class="form-control" value="${cliente.email}" placeholder="Digite um e-mail" />
			</div>

			<div class="form-group col-md-6">
				<label for="telefone">TELEFONE:</label> <input type="text" name="cliente.telefone" id="telefone" class="form-control" value="${cliente.telefone}" placeholder="(00)0000-0000" />
			</div>

			<div class="form-group col-md-6">
				<label for="celular">CELULAR:</label> <input type="text" name="cliente.celular" id="celular" class="form-control" value="${cliente.celular}" placeholder="(00)00000-0000" />
			</div>

			<div class="form-group col-md-6">
				<label for="cep">CEP:</label> <input type="text" name="cliente.cep"	id="cep" class="form-control" onblur="pesquisacep(this.value);" value="${cliente.cep}" placeholder="00000-000" />
			</div>
		

			<div class="form-group col-md-6">
				<label for="rua">RUA:</label> <input type="text"name="cliente.rua" id="rua" class="form-control" value="${cliente.rua}" />
			</div>

			<div class="form-group col-md-6">
				<label for="bairro">BAIRRO:</label> <input type="text" name="cliente.bairro" id="bairro" class="form-control" value="${cliente.bairro}" />
			</div>

			

			<div class="form-group col-md-6">
				<label for="uf">ESTADO:</label>
				 <input type="text"	name="cliente.estado" id="uf" class="form-control" value="${cliente.estado}" />
				 
			</div>
			
			<div class="form-group col-md-6">
				<label for="cidade">CIDADE:</label> 				
				<input type="text" name="cliente.cidade" id="cidade" class="form-control" value="${cliente.cidade}" />
			</div>
			
			
				
			
			
<!-- 			<div class="form-group col-md-6"> -->
<!-- 			   <select class="form-control" id="estado1" value="TO"></select> -->
			   
<!-- 			 </div> -->
<!-- 			   <select id="cidade1" value="Aragua�na"></select> -->
			   
			   
			   
			   
			   
			   
<!-- 					    <script language="JavaScript" type="text/javascript" charset="utf-8"> -->
<!--  					      new dgCidadesEstados({-->
<!--  					        cidade: document.getElementById('cidade1'),-->
 <!-- 					        estado: document.getElementById('estado1')-->
 	<!-- 				      })-->
<!-- 			    </script> -->
			
			
			
			
			
			
			
			
			
					
			
		</div>

		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#modalExemplo">Cadastrar</button>

		<!-- Modal -->
		<div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Cadastrar novo usuario</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Cancelar">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Deseja realmente cadastrar este novo usuario?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							onclick="msg()">Cancelar</button>
						<button type="submit" class="btn btn-primary" onclick="msg()">Confirmar</button>
					</div>
				</div>
			</div>
		</div>

	</form>

</div>


<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>