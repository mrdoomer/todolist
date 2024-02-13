<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<jsp:include page="../commons/jscss.jsp" />

<jsp:include page="../commons/header.jsp" />
<jsp:include page="../commons/left-sidebar.jsp" />

<title>Todo List Form</title>

</head>
<body>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8">
				<div class="todo-form">
					<h2>Add Todo</h2>
					<jsp:include page="../commons/Messages.jsp" />

					<form action ="SaveToDo" method="post">
						<div class="mb-3">
							<label for="task" class="form-label">Task</label> <input
								type="text" class="form-control" id="task" name="task" required>
						</div>
						<div class="mb-3">
							<label for="description" class="form-label">Description</label>
							<textarea class="form-control" id="description"
								name="description" rows="3"></textarea>
						</div>
						<input type="radio" id="Completed" name="radiobutton" value="1">
						<label for="Completed">Completed</label> <input type="radio" id="Uncompleted"
							name="radiobutton" value="0"> <label for="Uncompleted">Uncompleted</label>
						<div class="mb-3">
							<label for="dueDate" class="form-label">Due Date</label> <input
								type="date" class="form-control" id="dueDate" name="due_date">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
