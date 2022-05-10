<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión Categorías</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

<link href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css" rel="stylesheet">

<script src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>

<script src="https://kit.fontawesome.com/e2d055de0f.js" crossorigin="anonymous"></script>
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
					<li class="nav-item active"><a class="nav-link" href="/trazap/admin/">Inicio</a></li>
					<li class="nav-item"><a class="nav-link" href="/trazap/admin/gestionCategorias">Gestión Categorías</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Gestión Tipos de Productos</a></li>
				</ul>
				<a class="btn btn-sm btn-danger" href="/trazap/logout" style="float: right">Salir</a>
			</div>
		</nav>			
	</div>

	<section class="container pt-4">
		<div class="card">
			<div class="card-header text-white bg-dark">Gestión de Categorías</div>
			<div class="card-body text-center">
				<table class="table table-striped table-hover" id="tableCategorias">
					<thead>
						<tr>
							<th scope="col" data-field="idCategoria">ID</th>
							<th scope="col" data-field="nombre">Nombre</th>
							<th scope="col" data-field="opciones">Opciones</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</section>

	<div class="container pt-4">
		<button class="btn btn-dark" data-toggle="modal" data-target="#modalCreate" style="float: left">Agregar Categoría</button>
	</div>
	
	<!-- Modal Crear-->
	<div class="modal fade" id="modalCreate" tabindex="-1" aria-labelledby="modalModificarLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Agregar Categoría</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">ID</div>
						</div>
						<div class="input-group-text" id="idCategoriaCreate"></div>
					</div>
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">Nombre categoría</div>
						</div>
						<input type="text" class="form-control" placeholder="nombre de la categoría" id="nombreCategoriaCreate">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar<i class="fa-solid fa-ban"></i></button>
					<button type="button" class="btn btn-success" onclick="create()">Guardar<i class="fa-solid fa-floppy-disk"></i></button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal Update-->
	<div class="modal fade" id="modalUpdate" tabindex="-1" aria-labelledby="modalModificarLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modificar Categoría</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">ID</div>
						</div>
						<div class="input-group-text" id="idCategoriaUpdate"></div>
					</div>
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">Nombre Categoría</div>
						</div>
						<input type="text" class="form-control" placeholder="nombre de la categoría" id="nombreCategoriaUpdate">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar <i class="fa-solid fa-ban"></i></button>
					<button type="button" class="btn btn-success" onclick="update()">Guardar <i class="fa-solid fa-floppy-disk"></i></button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		
		$.ajax({
			method: 'GET',
			url: '/trazap/admin/categoriasApi'
		}).done((datos) => {
			console.log(datos);
			datos.body.forEach((elemento) => {
				console.log(elemento);
				elemento.opciones = elemento.opciones = '<button class="btn btn-xs btn-danger mr-3" onclick="deleteById(' + elemento.idCategoria + ')"><i class="fa-solid fa-trash-can"></i></button><button class="btn btn-xs btn-warning" data-toggle="modal" data-target="#modalUpdate" onclick="findById(' + elemento.idCategoria + ')"><i class="fa-solid fa-pen-to-square"></i></button>';
			});
			var $table = $('#tableCategorias');
			$table.bootstrapTable({data: datos.body});
		}).fail((datos) => {
			console.log(datos);
		});
		
		function create(){
			$.ajax({
				method: 'POST',
				url: '/trazap/admin/categoriasApi',
				contentType: 'application/json',
				data: JSON.stringify({
					'nombre': $('#nombreCategoriaCreate').val()
				})
			}).done((resp) => {
				console.log('done');
				console.log(resp);
				if(resp.messageList[0].type == 'OK'){
					$('#modalCreate').modal('hide');
					alert("Se ha creado correctamente el registro.");
					location.reload();
				}else{
					alert('Hubo un error.');
				}
			}).fail((error) => {
				console.log(error);
				alert("Hubo un error al añadir el registro");
			});
		}
		
		function deleteById(id){
			$.ajax({
				method: 'DELETE',
				contentType: 'application/json',
				url: '/trazap/admin/categoriasApi/' + id
			}).done((resp) => {
				console.log('done');
				if(resp.messageList[0].type == 'OK'){
					alert('Se ha eliminado el registro correctamente.');
				}else{
					alert('Hubo un error.');
				}
				location.reload();
			}).fail((error) => {
				console.log(error);
			});
		}
		
		function findById(id){
			$.ajax({
				method: 'GET',
				contentType: 'application/json',
				url: '/trazap/admin/categoriasApi/' + id
			}).done((resp) => {
				console.log(resp);
				$('#idCategoriaUpdate').text(resp.body.idCategoria);
				$('#nombreCategoriaUpdate').val(resp.body.nombre);
				$('#modalUpdate').modal('show');
			}).fail((error) => {
				console.log(error);
			});
		}
		
		function update(){
			$.ajax({
				method: 'PUT',
				contentType: 'application/json',
				url: '/trazap/admin/categoriasApi/' + $('#idCategoriaUpdate').text(),
				data: JSON.stringify({
					'nombre': $('#nombreCategoriaUpdate').val()
				})
			}).done((resp) => {
				if(resp.messageList[0].type == 'OK'){
					alert('Se ha modificado el registro correctamente.');
					$('#modalUpdate').modal('hide');
				}else{
					alert('Hubo un error.');
				}
				location.reload();
			}).fail((error) => {
				console.log(error);
				alert("Hubo un error en actualizar el registro.");
			});
		}
	</script>
</body>
</html>