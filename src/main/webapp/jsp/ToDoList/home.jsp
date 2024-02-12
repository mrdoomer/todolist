
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
			<c:if test="${rowCount > 0}">
				<h2 style="font-size: 19.2px; font-weight: bold;">My ToDos (${rowCount} Records Found)</h2>
				<div class="clearfix"></div>
				<div class="card card-body">
					<div class="table-responsive">
						<table class="table table-striped table-hover"
							style="font-size: 12px">
							<thead>
								<tr>
									<th>Sr.NO</th>
									<th>task</th>
									<th>Description</th>
									<th>due Date</th>
									<th>To Complete</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="sr" items="${Todo}" varStatus="status">
									
									<tr>
										<td><c:out value="${status.count}" /></td>
										<td><c:out value="${sr.task}" /></td>
										<td><c:out value="${sr.description}" /></td>
										<td><c:out value="${sr.due_date}" /></td>
										<td><c:out value="${sr.completed}" /></td>
									
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</div>

	</div>
	<%-- <jsp:include page="../common/footerDemo.jsp" /> --%>
</body>
</html>