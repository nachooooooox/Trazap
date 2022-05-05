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
<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Bootstrap 4.6 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
		<div class="row justify-content-md-center">
			<div class="card bg-light mt-5">
				<div class="card-header bg-info text-white text-center"><strong>Categorías</strong></div>
				<div class="card-body">
					<form:form id="idForm" action="/material" method="put" modelAttribute="material">
						<div class="form-group">
							<label>Nombre</label>
							<form:input path="nombreMaterial" id="nombre" class="form-control" name="nombre" required = "required"/>
						</div>
						<input type="submit" value="Agregar">
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<c:if test="${listaMateriales.size() > 0}">
			<div class="card bg-light mt-5">
				<div class="card-header bg-warning text-white text-center"><strong>Listado de Categorías</strong></div>
				<div class="card-body">
					<table class="table">
						<thead>
							<legend>Lista de Categorias</legend>
							<tr>
								<th><strong>ID</strong></th>
								<th><strong>Nombre</strong></th>
								<th><strong>Opciones</strong></th>
							</tr>
						</thead>
						<tbody>
							
								<c:forEach items="${listaMateriales}" var="material">
									<tr>
										<td><c:out value="${material.getIdMaterial()}"></c:out></td>
										<td><c:out value="${material.getPrecio()}"></c:out></td>
										<td><c:out value="${material.getNombreMaterial()}"></c:out></td>
									</tr>
								</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>