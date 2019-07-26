<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD</title>

<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/site.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/jquery.dataTables.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/fixedHeader.dataTables.min.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/responsive.dataTables.min.css'/>" rel="stylesheet" />
<link href="<c:url value='/barraProg/carregador.css'/>" rel="stylesheet" />





<script type="text/javascript" src="<c:url value='/js/jquery-3.4.1.js'/>"> </script>
<script type="text/javascript" src="<c:url value='/js/jquery.validate.js'/>"> </script>
<script type="text/javascript" src="<c:url value='/js/jquery.mask.js'/>"> </script>
<script type="text/javascript" src="<c:url value='/js/jquery.dataTables.js'/>"> </script>
<script type="text/javascript" src="<c:url value='/js/dataTables.fixedHeader.min.js'/>"> </script>
<script type="text/javascript" src="<c:url value='/js/dataTables.responsive.min.js'/>"> </script>
<script type="text/javascript" src="<c:url value='/js/cpf.validator.js'/>"> </script>
<script src="https://kit.fontawesome.com/db659eece9.js"></script>
<script type="text/javascript" src="<c:url value='/js/pace.min.js'/>"> </script>
<%-- <script type="text/javascript" src="<c:url value='/js/pace.min.js'/>"> </script> --%>



<script  src="<c:url value='/js/bootstrap.bundle.js'/>"> </script>

<script >

$(document).ready(function() {	
	
	var table =  $('#example').DataTable({
		responsive: true,
    	
         language: {
             search: "Pesquisar",
             info:           "Mostrando _START_ a _END_ de _TOTAL_ clientes",
             lengthMenu:    "Mostar _MENU_ clientes por página",
            	 paginate: {
                     first:      "Premier",
                     previous:   "Anterior",
                     next:       "Próximo",
                     last:       "Dernier",
                     
                 },
             
         }
    });
   
	 
	
	 
	new $.fn.dataTable.FixedHeader( table );
} );


</script>


   <!-- Via CEP -->
    <script type="text/javascript" >
    
    function limpa_formulário_cep() {
            //Limpa valores do formulário de cep.
            document.getElementById('rua').value=("");
            document.getElementById('bairro').value=("");
            document.getElementById('cidade').value=("");
            document.getElementById('uf').value=("");           
    }

    function meu_callback(conteudo) {
        if (!("erro" in conteudo)) {
            //Atualiza os campos com os valores.
            document.getElementById('rua').value=(conteudo.logradouro);
            document.getElementById('bairro').value=(conteudo.bairro);
            document.getElementById('cidade').value=(conteudo.localidade);
            document.getElementById('uf').value=(conteudo.uf);          
        } //end if.
        else {
            //CEP não Encontrado.
            limpa_formulário_cep();
            alert("CEP não encontrado.");
        }
    }
        
    function pesquisacep(valor) {

        //Nova variável "cep" somente com dígitos.
        var cep = valor.replace(/\D/g, '');

        //Verifica se campo cep possui valor informado.
        if (cep != "") {

            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;

            //Valida o formato do CEP.
            if(validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                document.getElementById('rua').value="...";
                document.getElementById('bairro').value="...";
                document.getElementById('cidade').value="...";
                document.getElementById('uf').value="...";               

                //Cria um elemento javascript.
                var script = document.createElement('script');

                //Sincroniza com o callback.
                script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

                //Insere script no documento e carrega o conteúdo.
                document.body.appendChild(script);

            } //end if.
            else {
                //cep é inválido.
                limpa_formulário_cep();
                alert("Formato de CEP inválido.");
            }
        } //end if.
        else {
            //cep sem valor, limpa formulário.
            limpa_formulário_cep();
        }
    };

    </script>
<style>
    #load {
    width: 100px;
    height: 100px;
    float: left;
    position: relative;
    top: 100px;
    left: 50%;
    color: gray;
 }
</style>
	

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="tm_nav">
  <a class="navbar-brand" href="${linkTo[IndexController].index()}">CRUD</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado" aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navega��o">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link"	href="${linkTo[ClienteController].formCpf()}">Cadastrar</a>
      </li>
      
      <li class="nav-item">
      <a class="nav-link" href="${linkTo[ClienteController].lista()}">Cadastrados</a>
      </li>
      
         <c:if test="${usuarioLogado.logado}">           
      		<div class="dropdown">
				<a class="nav-link" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Controle de Usuarios</a>							
					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<a class="dropdown-item " href="${linkTo[UsuarioController].formCadUsu()}">Cadastrar Usuario</a>
						<a class="dropdown-item " href="${linkTo[UsuarioController].listaUser()}">Gerenciar Usuarios</a>							    
					</div>							 
			</div>			
      	</c:if>
      	
      	<c:if test="${usuarioLogado.logado2}">
	      	<li class="nav-item">
	        	<a class="nav-link"	href="${linkTo[UsuarioController].formAttLog()}">Meus Dados</a>
	        </li>   
      	</c:if>
        	
      	<li class="nav-item"><a class="nav-link" href="${linkTo[LoginController].desloga()}">Deslogar</a></li>      	
 
    </ul>
    
		
  </div>
 	 <c:if test="${usuarioLogado.logado}">       	 
		<p id="logado"> Logado como ADM: (${usuarioLogado.nome})</p>		
	</c:if>
	
	<c:if test="${usuarioLogado.logado2}">       
		<p  id="logado">Logado como usuario comum: (${usuarioLogado.nome})</p>
	</c:if>
  
</nav>

	<div class="container">
	
		<main>
		