
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<table border="1" style="width: 80%;">
	<tr>
		<th>Id</th>
		<th>First Name</th>
		<th>Middle Name</th>
		<th>Last Name</th>
		<th>Gender</th>
		<th>Role</th>
		<th>Communication Language</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="emp" items="${list}">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.first_name}</td>
			<td>${emp.middle_name}</td>
			<td>${emp.last_name}</td>
			<td>${emp.gender}</td>
			<td>${emp.role}</td>
			<td>${emp.communicationlanguage}</td>
			<td><a href="editemp/${emp.id}">Edit</a></td>
			<td><a href="deleteemp/${emp.id}">Delete</a></td>
		</tr>
		<c:set var="pagination" value="${emp.pagination}" />
	</c:forEach>
</table>
<br />
<c:forEach var="i" begin="1" end="${pagination}">
	<a href="/SpringUserCRUD/viewemp/<c:out value = "${i}"/>"><c:out value="${i}"/></a> &nbsp;
</c:forEach>
<br />
<a href="/SpringUserCRUD/empform">Add New Employee</a>