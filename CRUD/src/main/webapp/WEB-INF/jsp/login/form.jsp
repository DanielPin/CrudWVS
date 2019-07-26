<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login CRUD</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link href="<c:url value='/css/Login/css/images/icons/favicon.ico'/>" rel="icon" type="image/png" />
<!--===============================================================================================-->
	<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet" />
<!--===============================================================================================-->
	<link href="<c:url value='/css/Login/fonts/font-awesome-4.7.0/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->
	<link href="<c:url value='/css/Login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->
	<link href="<c:url value='/css/Login/vendor/animate/animate.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->	
	<link href="<c:url value='/css/Login/vendor/css-hamburgers/hamburgers.min.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->
	<link href="<c:url value='/css/Login/vendor/animsition/css/animsition.min.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->
	<link href="<c:url value='/css/Login/vendor/select2/select2.min.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->	
	<link href="<c:url value='/css/Login/vendor/daterangepicker/daterangepicker.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/css/fontawesome.css'/>" rel="stylesheet" type="text/css" />
<!--===============================================================================================-->
	<link href="<c:url value='/css/Login/css/util.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/css/Login/css/main.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css" />
	
<style>
    #load {
    width: 100px;
    height: 100px;
    position: absolute;
    top: 30%;
    left: 45%;
    color: blue;
 }
</style>
	
</head>

<body>



	<div class="limiter">
	
		<div class="container-login100">
		
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
			<div class="load"> <i class="fa fa-cog fa-spin fa-3x fa-fw"></i><span class="sr-only">Loading...</span> </div>
				<form class="login100-form validate-form flex-sb flex-w" action="${linkTo[LoginController].autentica(null,null)}" method="POST">
					
					<span class="login100-form-title p-b-32">
						Faça login para acessar o sistema
					</span>

					<span class="txt1 p-b-11">
						Usuário
					</span>
					<div class="wrap-input100 validate-input m-b-36" data-validate = "Username is required">
						<input class="input100" type="text" name="login" id="login">
						<span class="focus-input100"></span>
					</div>
					
					<span class="txt1 p-b-11">
						Senha
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="password" name="senha" id="senha" >
						<span class="focus-input100"></span>
					</div>
					
					<p id="erro">${erro}</p>

					<div class="container-login100-form-btn">
						<button type="submit"  class="login100-form-btn">
							Acessar
						</button>
					</div>
					
								
				</form>
			</div>
		</div>
	</div>
	
	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="<c:url value='/css/Login/vendor/jquery/jquery-3.2.1.min.js'/>"> </script>
<!--===============================================================================================-->
	<script src="<c:url value='/css/Login/vendor/animsition/js/animsition.min.js'/>"> </script>
<!--===============================================================================================-->
	<script src="<c:url value='/css/Login/vendor/bootstrap/js/popper.js'/>"> </script>
	<script src="<c:url value='/css/Login/vendor/bootstrap/js/bootstrap.min.js'/>"> </script>
<!--===============================================================================================-->
	<script src="<c:url value='/css/Login/vendor/select2/select2.min.js'/>"> </script>
<!--===============================================================================================-->
	<script src="<c:url value='/css/Login/vendor/daterangepicker/moment.min.js'/>"> </script>
	<script src="<c:url value='/css/Login/vendor/daterangepicker/daterangepicker.js'/>"> </script>
<!--===============================================================================================-->
	<script src="<c:url value='/css/Login/vendor/countdowntime/countdowntime.js'/>"> </script>
<!--===============================================================================================-->
	<script src="<c:url value='/css/Login/js/main.js'/>"> </script>
	
</body>
</html>