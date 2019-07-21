<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="/WEB-INF/jsp/header.jsp"></c:import>



<div id="tamanho_form2">
<p id="cad">${cad}</p>
<form action="${linkTo[ClienteController].busca(null) }" method="POST" id="cad_cliente">
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="cpf">CPF:</label> 
			<input type="text" name="cpf" id="cpf" class="form-control"></input>
		</div>
		
	</div>
	<button type="submit" class="btn btn-primary" >Continuar</button>
</form>


</div>

<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>