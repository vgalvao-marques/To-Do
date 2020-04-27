<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>New Task</title>
<c:import url="templates/head-content.jsp" />
</head>
<body>
	<c:import url="templates/navbar.jsp" />
				<form class="form-group divform" action="newtask" method="post">
					<div class="form-row">
						<div>
							<h5 class="header-form">NEW TASK</h5>
						</div>

						<div class="form-group col-12">
							<label for="task" style="font: bold !important;">Task</label> <input
								type="text" class="form-control input-form" id="task"
								maxlength="60" name="title" required="required">
						</div>
					</div>
					<div >
						<div class="form-group">
							<label for="notes">Note</label>
							<textarea class="form-control input-form" id="notes" rows="3"
								maxlength="400" name="notes" required="required"></textarea>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-6">
							<label for="date">Date</label> <input type="date"
								class="form-control input-form" id="date" name="date" required="required">
						</div>
						<div class="form-group col-6">
							<label for="time">Time</label> <input type="time"
								class="form-control input-form" id="time" name="time" required="required">
						</div>
					</div>
					<button type="submit" class="btn btn-secondary btn-lg btn-block">Add
						Task</button>
				</form>
				
	<c:import url="templates/footer-scripts.jsp" />
</body>


</html>