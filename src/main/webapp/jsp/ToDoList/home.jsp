
<!DOCTYPE html>

<html lang="en">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../commons/jscss.jsp" />

<!-- <style>
td {
	padding: 10px;
}

.selectCheckBox {
	width: 30px; /*Desired width*/
	height: 30px; /*Desired height*/
}

.red {
	color: red;
	font-size: 14px;
}

[type="checkbox"]:not (:checked ), [type="checkbox"]:checked {
	position: relative;
	left: 0px;
	opacity: 1;
}
</style> -->




<body>

	<jsp:include page="../commons/header.jsp" />
	<jsp:include page="../commons/left-sidebar.jsp" />

	<div class="container">

		<h2 class="red text-capitalize">Hello</h2>
		<div class="clearfix"></div>
		<div class="panel-content-wrapper">

			<p>Dear Student, You have chosen below Service Request. Please
				fill in required information below before proceeding for Payment.</p>
			<!-- <p>You won't be able to submit service Request for next 48hrs . For details refer to "My Communications" Tab</p> -->

			<form action="saveCorrectDOB" method="post">
				<!-- //	modelAttribute="sr" enctype="multipart/form-data"> -->

				<fieldset>

					<div class="row">
						<div class="col-md-8">

							<div class="form-group">
								<label for="serviceRequestType">Service
									Request Type:</label>
								<p>Hello</p>
							</div>

							<div class="form-group">
								<label for="Charges">Charges:</label>
								<p>No Charges</p>
							</div>

							<div class="form-group">
								<label for="dob">Correct Date of Birth:</label> <input
									type="date" required="required" name="dob" class="form-control"
									id="dob">
							</div>

							<div class="form-group">
								<label for="sscMarksheet">Please Upload SSC Marksheet as
									Proof of Date of Birth:</label> <input type="file" name="sscMarksheet"
									id="sscMarksheet" required="required" class="form-control">
							</div>

							<div class="form-group">
								<label class="control-label" for="submit"></label>
								<div class="controls">
									<button id="submit" name="submit"
										class="btn btn-large btn-primary" formaction="saveCorrectDOB"
										onClick="return confirm('Are you sure you want to save this information?');">Save
										Service Request</button>

									<button id="backToSR" name="BacktoNewServiceRequest"
										class="btn btn-danger" formaction="selectSRForm"
										formnovalidate="formnovalidate">Back to New Service
										Request</button>

								</div>
							</div>

						</div>
					</div>

				</fieldset>
			</form>


		</div>

	</div>
	<%-- <jsp:include page="../common/footerDemo.jsp" /> --%>


</body>
</html>