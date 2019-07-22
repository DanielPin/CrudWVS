		</main>
		</div>
	</body>
		
<!-- 	Script de validação api jquery validation -->
<script type="text/javascript">
  $('#cad_cliente').validate({
    rules: {
      "cliente.nome": {
        required: true     
      },
      "cliente.email":{
    	  required: true,
    	  email:true
      },
      "cliente.rg":{
    	  required: true    	  
      },
      "cliente.cpf":{
    	  required: true,
    	  verificaCPF: true
      },
      "cliente.rua":{
    	  required: true
      },
      "cliente.bairro":{
    	  required: true
      },
      "cliente.cep":{
    	  required: true,
    	  minlength: 9,
          maxlength: 9
      },
      "cliente.cidade":{
    	  required: true
      },
      "cliente.estado":{
    	  required: true
      },
      "cliente.telefone":{
    	  minlength: 13,
          maxlength: 13
      },
      "cliente.celular":{
    	  minlength: 14,
          maxlength: 14
      },
      "cpf":{
    	  required: true,
    	  verificaCPF: true
      },     
      
      
    },
    messages:{
    	"cliente.nome":{
    		required: "Campo nome necessario"
    	},
    	"cliente.cpf":{
    		required: "Campo cpf obrigatorio"
    	},
    	"cliente.mail":{
    		required: "E-Mail obrigatorio",
    		email:"Digite um e-mail valido"
    	},
    	    	
    }
    
  });
</script>

<script>
$('#cad_usuario').validate({
    rules:{
    	"usuario.senha":{
			  required: true,
			  minlength: 6,
			  maxlength: 18
		},
    	 "usuario.nome": {
 		    required: true     
 		},
 		"usuario.email":{
 			  required: true,
 			  email:true
 		},
 		"usuario.login":{
 			  required: true,
 			  minlength:2
 		},
 		"confSenha":{
 			required: true,
 			minlength: 6,
			maxlength: 18
 		},
 		    
    }, 
    messages:{
    	"usuario.senha":{
    	    minlength: "Valor minimo 6 caracteres",
    	    maxlength: "Maximo 19 caracteres"
    	},
    	"confSenha":{
    		minlength: "Valor minimo 6 caracteres",
    	    maxlength: "Maximo 19 caracteres"
    	}
    }
    });



</script>



<script>

$('#att_usuarioLogado').validate({
    rules:{
    	"usuario.senha":{
			  required: true,
			  minlength: 6,
			  maxlength: 18
		},
    	 "usuario.nome": {
 		    required: true     
 		},
 		"usuario.email":{
 			  required: true,
 			  email:true
 		},
 		"usuario.login":{
 			  required: true,
 			  minlength:2
 		},
 		"usuario.senhaConf": {
 			 required: true,
 		},
 		
 		    
    }, 
    messages:{
    	"usuario.senha":{
    	    minlength: "Valor minimo 6 caracteres",
    	    maxlength: "Maximo 19 caracteres"
    	}
    }
    });



</script>


<!--  Script para aparecer o modal quando deletar usuario -->
<script type="text/javascript">

$(document).ready(function(){
	$("#myModal1").modal('hide');
	$("#myModal1").modal('${sucesso}');
	
	});

</script>

<script type="text/javascript">

$(document).ready(function(){
	$("#login").modal('hide');
	$("#login").modal('${sucesso}');
	
	});

</script>

<!-- Script de mascaras do formulario de cadastro -->
<script>
//Mascara CPF
$(document).ready(function(){
  $('#cep').mask("00000-000");
  $('#celular').mask("(00)00000-0000");
  $('#cpf').mask("000.000.000-00")
});
</script>




</html>