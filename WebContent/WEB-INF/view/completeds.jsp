<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Completeds</title>
<c:import url="templates/head-content.jsp" />
</head>
<body>
	<c:import url="templates/navbar.jsp" />

	<c:forEach items="${tasks}" var="task">
	<div class="card text-white bg-dark mb">
		<div class="card-header">
			${task.title}
			<a class="todo-link" href="todo?id=${task.id}">To Do</a>
		</div>
		<div class="card-body">			
			
			<p class="card-text">${task.notes}</p>
				
			<a class="edit-link" href="edit?id=${task.id}">Edit</a>
	</div>
	</div>
	
	</c:forEach>


	<c:import url="templates/footer-scripts.jsp" />
</body>

</html>