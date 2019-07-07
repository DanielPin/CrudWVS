<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD</title>

<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/site.css'/>" rel="stylesheet" />


<script type="text/javascript" src="<c:url value='/js/jquery-3.4.1.js'/>"> </script>
<script type="text/javascript" src="<c:url value='/js/jquery.validate.js'/>"> </script>
<script type="text/javascript" src="<c:url value='/js/jquery.mask.js'/>"> </script>
<script type="text/javascript" src="<c:url value='/js/cidades-estados-1.4-utf8.js'/>"> </script>
<script  src="<c:url value='/js/bootstrap.js'/>"> </script>


</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="${linkTo[IndexController].index()}">CRUD</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado" aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navega��o">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link"	href="${linkTo[ClienteController].form()}">Cadastrar</a>
      </li>
      
      <li class="nav-item">
      <a class="nav-link" href="${linkTo[ClienteController].lista()}">Cadastrados</a>
      </li>
     
    </ul>
    <form class="form-inline my-2 my-lg-0" action="<c:url value="/cliente/busca"/>">
      <input class="form-control mr-sm-2" type="search" name="nome" placeholder="Pesquisa por nome" aria-label="Pesquisa por nome">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
    </form>
  </div>
</nav>


	<div class="container" id="divContent">
		<main>