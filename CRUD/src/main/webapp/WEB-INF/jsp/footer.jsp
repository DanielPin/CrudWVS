		</main>
		</div>
	</body>
	
<script type="text/javascript">
  $('#cad_cliente').validate({
    rules: {
      "cliente.nome": {
        required: true     
      },
      "cliente.cpf": {
        required: true,
        minlength: 14,
        maxlength: 14
      },
      "cliente.email":{
    	  required: true,
    	  email:true
      },
      "cliente.rg":{
    	  required: true    	  
      },
      "cliente.rua":{
    	  required: true
      },
      "cliente.bairro":{
    	  required: true
      },
      "cliente.cep":{
    	  required: true
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
      }
      
      
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
    	}
    	
    }
    
  });
</script>

<script>

$('[name="cliente.estado"]').click(function(){

	// ocultando todas
	$('[name="cidades"] option').css('display', 'none');
	 
	// exibindo as do estado selecionado
	$('[name="cidades"] .' + $(this).val()).css('display', '');

	});


</script>

<script type="text/javascript">	
		
		$(document).ready(function () {
		
			$.getJSON('estados_cidades.json', function (data) {
				var items = [];
				var options = '<option value="">escolha um estado</option>';	
				$.each(data, function (key, val) {
					options += '<option value="' + val.nome + '">' + val.nome + '</option>';
				});					
				$("#estados").html(options);				
				
				$("#estados").change(function () {				
				
					var options_cidades = '';
					var str = "";					
					
					$("#estados option:selected").each(function () {
						str += $(this).text();
					});
					
					$.each(data, function (key, val) {
						if(val.nome == str) {							
							$.each(val.cidades, function (key_city, val_city) {
								options_cidades += '<option value="' + val_city + '">' + val_city + '</option>';
							});							
						}
					});
					$("#cidades").html(options_cidades);
					
				}).change();		
			
			});
		
		});
		
	</script>		


<script>
//Mascara CPF
$(document).ready(function(){
  $('#cpf').mask('000.000.000-00');
  $('#rg').mask('00.000.000-0');
  $('#cep').mask("00000-000");
  $('#telefone').mask("(00)0000-0000");
  $('#celular').mask("(00)00000-0000");
});
</script>



</html>