<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<c:import url="templates/head-content.jsp" />
</head>
<body>

	<body>
	<div class="login-page">
    <div class="form">
      <form class="register-form" action="register" method="POST">
        <div>
					<h1 class="todo-login">TO DO</h1>
				</div>
	
		<span>${msg}</span>
        <input name="name" type="text" placeholder="name" />
        <input name="password" type="password" placeholder="password" />
        <input name="email" type="text" placeholder="email address" />

        <button type="submit">create</button>
        <p class="message">Already registered? <a href="login">Sign In</a>
				</p>
      </form>
    </div>
  </div>
	

	<c:import url="templates/footer-scripts.jsp" />
</body>


</html>