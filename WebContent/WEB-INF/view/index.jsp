<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<c:import url="templates/head-content.jsp" />
</head>
<body>
	<div class="login-page">
		<div class="form">
			<div>
				<h1 class="todo-login">TO DO</h1>
			</div>
			<span>${msg}</span>
			<form class="login-form" action="login" method="POST">

				<input name="email" type="text" placeholder="user email" /> <input
					name="password" type="password" placeholder="password" />

				<button type="submit">login</button>
				<p class="message">
					Not registered? <a href="register">Create an account</a>
				</p>
			</form>
		</div>
	</div>
	<c:import url="templates/footer-scripts.jsp" />
</body>
</html>