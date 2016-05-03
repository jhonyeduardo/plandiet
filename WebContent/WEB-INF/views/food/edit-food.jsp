<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de alimentos</title>
		
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/semantic.min.css" />
	</head>
	<body>
		<div class="ui two column centered grid">
			<div class="column" style="padding-top: 50px">
				<form class="ui form form-adiciona" method="POST" action="add">
				  <div class="fields centered">
				    <div class="field">
				      <input placeholder="Insira um alimento" name="id" type="hidden" value="${foodEdit.id}">
				      
				      <label>Alimento</label>
				      <input placeholder="Insira um alimento" name="name" type="text" value="${foodEdit.name}">
				    </div>
				    <div class="field">
				      <label>Calorias</label>
				      <div class="ui right labeled input">
				      	  <input type="number" name="calorie" placeholder="Quantidade de caloria" value="${foodEdit.calorie}">
						  <div class="ui basic label">
						    cal
						  </div>
					  </div>
				    </div>
				  </div>
				  <div class="ui submit positive button" style="width: 53%" onClick="document.forms[0].submit();">Enviar</div>
				</form>
				
				<table class="ui very basic table">
					<thead>
						<tr>
							<th>Identificação</th>
							<th>Alimento</th>
							<th>Caloria</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${foods}" var="food">
							<tr>
								<td>${food.id}</td>
								<td>${food.name}</td>
								<td>${food.calorie}</td>
								<td> 
									<div class="ui icon positive button" onclick="updateItem(${food.id})">
									<i class="edit icon"></i>
									</div>
									<div class="ui icon negative button" onclick="removeItem(${food.id})">
									<i class="remove icon"></i>
									</div> 
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="3">Total de calorias: ${amountCalories} </td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<script></script>
		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-beta1/jquery.min.js"></script>
		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/semantic.min.js"></script>
		
		<script>
			function removeItem(id) {
				var foodId;

				foodId = "id=" + id;

				$.ajax({
				  method: "POST",
				  url: "/PlanDiet/food/remove",
				  data: foodId
				}).done(function( msg ) {
					location.href = 'http://localhost:8080/PlanDiet/food/list';
				});
			}

			function updateItem(id) {
				var foodId;

				foodId = "id=" + id;

				$.ajax({
				  method: "POST",
				  url: "/PlanDiet/food/update",
				  data: foodId
				});
			}
		</script>
		

	</body>
</html>