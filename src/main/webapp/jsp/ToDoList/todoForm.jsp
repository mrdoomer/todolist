
<!DOCTYPE html>

<html lang="en">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../commons/jscss.jsp" />





<body>

	<jsp:include page="../commons/header.jsp" />
	<jsp:include page="../commons/left-sidebar.jsp" />

	<div class="container">

		<h2 class="red text-capitalize">List Of Todos</h2>
		<div class="clearfix"></div>
		<div class="panel-content-wrapper">
			<c:if test="${rowCount eq 0 }">
				<h1>
					<b>No ToDo Found</b>
				</h1>
			</c:if>
			<c:if test="${rowCount > 0}">
				<h2 style="font-size: 19.2px; font-weight: bold;">My ToDos
					(${rowCount} Records Found)</h2>
				<div class="clearfix"></div>
				<div class="card card-body">
					<div class="table-responsive">
						<table class="table" style="font-size: 12px">
							<thead>
								<tr>
									<th>Sr.NO</th>
									<th>task</th>
									<th>Description</th>
									<th>due Date</th>
									<th>To Complete</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="sr" items="${Todo}" varStatus="status">

									<tr>
										<td><c:out value="${status.count}" /></td>
										<td ><c:out value="${sr.task}" /></td>
										<td ><c:out
												value="${sr.description}" /></td>
										<td ><c:out
												value="${sr.due_date}" /></td>
										<td ><c:out
												value="${sr.completed}" /></td>
										<td><button data-todo-id="${sr.id }" data-todo-task="${sr.task}" 
										data-todo-description="${sr.description}" data-todo-due_date="${sr.due_date}" 
										data-todo-completed ="${sr.completed}" value="Edit"  
										onclick="getData(this)"> Edit</button>
										 <input type="button"
											value="Delete" data-todo-id=${sr.id } class="delete"
											onclick="deleteTodo(this)">
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- Button trigger modal -->


					<div class="modal" id="exampleModal" tabindex="-1">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title">Edit Todo</h5>
									<button type="button" class="btn-close" onclick="closeModal()"></button>
								</div>
								<div class="modal-body">
								<div id="success" class="alert alert-success d-none" role="alert"></div>
								<div id="fail"class="alert alert-danger d-none" role="alert"></div>
									<div class="mb-3">
										<label for="task" class="form-label">Task</label> <input
											type="text" class="form-control" id="task" name="task"
											required>
										<input
											type="hidden" class="form-control" id="id" name="id"
											required/>
																					
									</div>
									<div class="mb-3">
										<label for="description" class="form-label">Description</label>
										<textarea class="form-control" id="description"
											name="description" rows="3"></textarea>
									</div>
									<input type="radio" id="Completed" name="radiobutton" value="1">
									<label for="Completed">Completed</label> <input type="radio"
										id="Uncompleted" name="radiobutton" value="0"> <label
										for="Uncompleted">Uncompleted</label>
									<div class="mb-3">
										<label for="dueDate" class="form-label">Due Date</label> <input
											type="date" class="form-control" id="dueDate" name="due_date">
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										onclick ="closeModal()">Close</button>
									<button type="button" class="btn btn-primary" onclick="updateTodo()">Save
										changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>

	</div>
	<script>
	function getData(obj){
		var description = obj.getAttribute('data-todo-description');
		var task =obj.getAttribute('data-todo-task');
		var due_date =obj.getAttribute('data-todo-due_date');
		var completed =obj.getAttribute('data-todo-completed');
		var id = obj.getAttribute('data-todo-id');
		if (completed == 1){
		document.getElementById('Completed').checked = true;

		}
		else{
			document.getElementById('Uncompleted').checked = true;

		}
		document.getElementById('description').value = description;
		document.getElementById('id').value = id;
		document.getElementById('dueDate').value = due_date;
		document.getElementById('task').value = task;
		
		$('#exampleModal').show();
			
	}
		
	function closeModal(){
		$('#exampleModal').hide();
		
	}
	function updateTodo(){
      $.ajax({
		      type: "POST",
		      url: "updateTodo",
		      data: {
		        'id': document.getElementById('id').value ,
		        'description': document.getElementById('description').value,
		        'due_date': document.getElementById('dueDate').value,
		        'task' : document.getElementById('task').value,
		        'completed' : document.getElementById('Completed').value
		      
		      },
		      success: function(result) {
		        alert('Successfully Updated TOdo');
		      },
		      error: function(result) {
		        alert('error in updating todo');
		      }
		    });
	}
function deleteTodo(obj){
	var id =obj.getAttribute('data-todo-id');
	var confirmation = confirm('Are you sure you want to Delete this information?');
	if (confirmation){
		 $.ajax({
		      type: "POST",
		      url: "deleteTodo",
		      data: {
		        'id': id ,
		      },
		      success: function(result) {
		        alert('Successfully Deleted Todo');
		      },
		      error: function(result) {
		        alert('error in Deleting Todo');
		      }
		    });
	}
	
	
}
	</script>
</body>
</html>