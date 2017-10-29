<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Finance Report</title>

<style>
		div#mySidenav, div#myEditSidenav {
			height: 100%;
			width: 0;
			position: fixed;
			z-index: 1;
			top: 0;
			right: 0;
			overflow-x: hidden;
			transition: 0.5s;
			margin-top: 60px;
		}
		a:hover {
			text-decoration: none !important;
		}
		.tab {
			margin-top : 20px;
		}
		.myfont
		{
		   font-size:10;
		   
		}
		</style>
		
		
		
		
		
</head>
<body>

<div class="container-fluid">
	<jsp:include page="includes/header.jsp"></jsp:include>

<div class="row">
				<div class="col-sm-3 col-md-2 col-lg-2">
					<jsp:include page="includes/navigationMenu.jsp"></jsp:include>
				</div>
				<div class="col-lg-10">
				<form class="form-horizontal" action="generateReportFinance">
				<fieldset>
							<legend>REPORT</legend>
							<div class="row">
							<div class="col-sm-8">
							<div id="containergraph" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
							</div>
							<div class="col-sm-4">
							
							<label><strong>TOTAL AMOUNT REQUESTED:</strong>&nbsp;&nbsp;${totalAmountRequested}</label><br><br>
							
							<label><strong>TOTAL AMOUNT APPROVED:</strong>&nbsp;&nbsp;${totalAmountApproved}</label>
							</div>
							</div>
							
							<div class="row">
							
								<div class="col-md-3 text-center">
								<div class="form-group">
								<label class="col-md-1"><strong>From:</strong></label>
								<div class="col-md-11"><input type="date" class="form-control" name="startdate" required></div>
								 </div>
								  </div>
								<div class="col-md-3 text-center"><div class="form-group"><label class="col-md-1"><strong>To:</strong></label><div class="col-md-11"><input type="date"  class="form-control" name="enddate" required></div> </div> </div>
								<div class="col-md-3"></div>
								<div class="col-md-3"></div>
							</div>	
							
		                      <div class="row">
								<div class="col-md-3 text-center">
								   <div class="form-group">
									<label class="col-md-1"><strong>Type</strong></label>
									<div class="col-md-11">
									<select class="form-control" name="type">
									<option value="-1">Choose Type</option>
									 <option value="0">Payroll</option>
								      <option value="1">Non Payroll</option>
								    </select>
							   		</div>
								</div>
								</div>
								<div class="col-md-3 text-center">
								<div class="form-group">
									<label class="col-md-1"><strong>Category</strong></label>
									<div class="col-md-11">
									<select class="form-control" name="category">
									<option value="-1"> Choose Category</option>
									 <c:forEach var="x" items="${categories}">
								      <option value="${x.id}">${x.name}</option>
								     </c:forEach>
								    </select>
							   
									</div>
								</div>
								</div>
								<div class="col-md-3 text-center">
								<div class="form-group">
									<label class="col-md-1"><strong>Project</strong></label>
									<div class="col-md-11">
									<select class="form-control" name="project">
									<option value="-1">Choose Project</option>
									 <c:forEach var="x" items="${projects}">
								      <option value="${x.id}">${x.name}</option>
								     </c:forEach>
								    </select>
							   
									</div>
								</div>
								</div>
								<div class="col-md-3 text-center">
								<div class="form-group">
									<label class="col-md-1"><strong>Status</strong></label>
									<div class="col-md-11">
									<select class="form-control" name="status">
									<option value="-1">Choose Status</option>
								      <option value="1">Approved</option>
								      <option value="2">Rejected</option>
								      <option value="3">Partial</option>
								     
								  		</select>
							  		 </div>
								</div>
								</div>
								
							</div>
							<div class="row">
							<div class="col-sm-4" style="padding-top:10px">
							<button value="submit" type="submit" class="btn btn-primary">Generate Report</button>
							
							</div>
							<div class="col-sm-8"></div>
							</div>
	   
	   
	   <div class="row">
	
		  <div class="col-md-12" style="padding-top:10px;">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							Request Id
						</th>
						<th>
							Employee Name
						</th>
						<th>
							Submission Date
						</th>
						<th>
							Type
						</th>
						<th>
							Category
						</th>
						<th>
							Project
						</th>
						<th>
							Amount Requested
						</th>
						<th>
							Amount Approved
						</th>
						<th>
							Status
						</th>
					</tr>
				</thead>
				
				<tbody>
		<c:forEach var="x" items="${reimbursementrequets}">
		<tr>
		<td><c:out value="${x.reimbursementId}"></c:out></td>
		<td><c:out value="${x.employee.firstName} ${x.employee.lastName}"></c:out></td>
		<td class="date"><c:out value="${x.submissionDate}"></c:out></td>
		<%--  <td class="date"><c:out value="${x.ManagerApprovalDate}"></c:out></td> --%>
		<td><c:out value="${x.category.type}"></c:out></td>
		<td><c:out value="${x.category.name}"></c:out></td> 
		<td><c:out value="${x.employee.assignedToProject.name}"></c:out></td>
		<td><c:out value="${x.amountRequested}"></c:out></td>
		<td><c:out value="${x.amountApproved}"></c:out></td>
			<td><c:if test="${x.amountApproved==0}">
		      REJECTED
		    </c:if>
		    <c:if test="${x.amountApproved!=0 &&(x.amountApproved<x.amountRequested)}">
		     PARTIAL
		    </c:if>
		      <c:if test="${x.amountApproved!=0 &&(x.amountApproved==x.amountRequested)}">
		     APPROVED
		    </c:if>
		 </td>
		</tr>
		</c:forEach>
				</tbody>
			</table>
	</div>
		</div>
				</fieldset>
			</form>
			<div class="row">
				<div class="col-md-4" style="margin-left:10px;">
				<form action="downloadpdf" method="post">
				<input type="hidden" value="${pdfName}" name="fileName">
				<button value="submit" type="submit" class="btn btn-primary">Download Report</button>
		   		</form>
		   		 </div>
			</div>
			</div>
				<div class="col-md-8">
			 		</div>
				</div>
				
</div>

<script>
  $( document ).ready( function() {
	$( '.date' ).each( function() {  
	 var date = $( this ).get( 0 ).innerHTML.split( ' ' )[ 0 ];
	 $( this ).get( 0 ).textContent = date;
	});
   });

  Highcharts.chart('containergraph', {
	    chart: {
	        plotBackgroundColor:null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text:'AMOUNT'
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                style: {
	                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'red'
	                }
	            }
	        }
	    },
	    series: [{
	        name: 'Brands',
	        colorByPoint: true,
	        data: [
	        	{
	        	name: 'Approved',
	        	y: ${totalAmountApproved}
	            },
	           {
	        	name: 'Rejected',
	        	y: ${totalAmountRequested-totalAmountApproved}
	           }]
	            
	    }]
	});





</script>
</body>
</html>