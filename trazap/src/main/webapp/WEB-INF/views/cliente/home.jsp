<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home de Usuario</title>
<!-- Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Bootstrap 4.6 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>

<script src="https://kit.fontawesome.com/e2d055de0f.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
	
			<div class="collapse navbar-collapse ml-5 mr-5" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/trazap/user/">Inicio</a></li>
					<li class="nav-item"><a class="nav-link" href="/trazap/user/gestionBodegas">Gestión Bodega</a></li>
					<li class="nav-item"><a class="nav-link" href="/trazap/user/gestionProductos">Gestión Productos</a></li>
				</ul>
				<a class="btn btn-sm btn-danger" href="/trazap/logout" style="float: right">Salir</a>
			</div>
		</nav>			
	</div>
	<div class="container">
		<div class="row justify-content-md-center text-center">
			<div class="col">
				<div class="card bg-light mt-5">
					<div class="card-body">
						<p>Sistema que permite gestionar las bodegas, en donde se puede ver, crear, eliminar y modificar </p>
						<a class="btn btn-sm btn-primary" href="/trazap/user/gestionBodegas">IR</a>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card bg-light mt-5">
					<div class="card-body">
						<p>Sistema que permite gestionar los productos en bodegas, en donde se puede ver, crear, eliminar y modificar </p>
						<a class="btn btn-sm btn-primary" href="/trazap/user/gestionProductos">IR</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>