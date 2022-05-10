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
<title>Gestión Tipo de Productos</title>
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
					<li class="nav-item"><a class="nav-link" href="/trazap/admin/gestionTipoProducto">Gestión Tipos de Productos</a></li>
				</ul>
				<a class="btn btn-sm btn-danger" href="/trazap/logout" style="float: right">Salir</a>
			</div>
		</nav>			
	</div>
	<section class="container pt-4">
		<div class="card">
			<div class="card-header text-white bg-dark">Gestion tipo de producto</div>
			<div class="card-body text-center">
				<table class="table table-striped table-hover" id="tableTipoProductos">
					<thead>
						<tr>
							<th scope="col" data-field="idTipoProductos">ID</th>
							<th scope="col" data-field="descripcion">Descripcion</th>
							<th scope="col" data-field="opciones">Opciones</th>							
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</section>

	<div class="container pt-4">
		<button class="btn btn-dark" data-toggle="modal" data-target="#modalCreate" style="float: left">Agregar Tipo Producto</button>
	</div>
	
	<!-- Modal Crear-->
	<div class="modal fade" id="modalCreate" tabindex="-1" aria-labelledby="modalModificarLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Agregar Tipo Producto</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">ID</div>
						</div>
						<div class="input-group-text" id="idTipoProductoCreate"></div>
					</div>
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">Nombre Tipo Producto</div>
						</div>
						<input type="text" class="form-control" placeholder="descripcion tipo de producto" id="descripcionTipoProductoCreate">
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
					<h5 class="modal-title" id="exampleModalLabel">Modificar Tipo Producto</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">ID</div>
						</div>
						<div class="input-group-text" id="idTipoProductoUpdate"></div>
					</div>
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">Nombre Tipo Producto</div>
						</div>
						<input type="text" class="form-control" placeholder="descripcion tipoProducto" id="descripciontipoProductoUpdate">
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
			url: '/trazap/admin/tipoProductoApi'
		}).done((data) => {
			data.body.forEach((elemento) => {
				elemento.opciones = elemento.opciones = '<button class="btn btn-xs btn-danger mr-3" onclick="deleteById(' + elemento.idTipoProducto + ')"><i class="fa-solid fa-trash-can"></i></button><button class="btn btn-xs btn-warning" data-toggle="modal" data-target="#modalUpdate" onclick="getById(' + elemento.idTipoProducto + ')"><i class="fa-solid fa-pen-to-square"></i></button>';
			});
			var $table = $('#tableTipoProductos');
			$table.bootstrapTable({data: data.body});
		}).fail((datos) => {
			console.log(datos);
		});
		
		function create(){
			$.ajax({
				method: 'POST',
				contentType: 'application/json',
				url: '/trazap/admin/tipoProductoApi',
				data: JSON.stringify({
					'descripcion': $('#descripcionTipoProductoCreate').val(),
				})
			}).done((resp) => {
				console.log('done');
				console.log(resp);
				if(resp.messageList[0].type=='OK'){
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
				url: '/trazap/admin/tipoProductoApi/'+id
			}).done((resp) => {
				console.log('done');
				if(resp.messageList[0].type=='OK'){
					alert('Se ha eliminado el registro correctamente.');
				}else{
					alert('Hubo un error.');
				}
				location.reload();
			}).fail((error) => {
				console.log(error);
			});
		}
		
		function getById(id){
			$.ajax({
				method: 'GET',
				contentType: 'application/json',
				url: '/trazap/admin/tipoProductoApi/'+id
			}).done((resp) => {
				console.log(resp);
				$('#idTipoProductoUpdate').text(resp.body.idTipoProducto);
				$('#descripciontipoProductoUpdate').val(resp.body.descripcion);
				$('#modalUpdate').modal('show');
			}).fail((error) => {
				console.log(error);
			});
		}
		
		function update(){
			$.ajax({
				method: 'PUT',
				contentType: 'application/json',
				url: '/trazap/admin/tipoProductoApi/'+ $('#idTipoProductoUpdate').text(),
				data:JSON.stringify({
					
					'descripcion': $('#descripciontipoProductoUpdate').val(),
				})
			}).done((resp) => {
				console.log(resp);
				if(resp.messageList[0].type=='OK'){
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