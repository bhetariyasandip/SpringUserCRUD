<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Employee</h1>
<form:form method="POST" action="/SpringUserCRUD/editsave">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="id" /></td>
		</tr>
		<tr>
			<td>First Name :</td>
			<td><form:input path="First_name" /></td>
		</tr>
		<tr>
			<td>Middle Name :</td>
			<td><form:input path="Middle_name" /></td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td><form:input path="Last_name" /></td>
		</tr>
		<tr>
			<td>Gender :</td>
			<td>
				<%-- <form:input path="Gender" /> --%> <form:radiobutton
					path="Gender" value="Male" />Male <form:radiobutton path="Gender"
					value="Female" />Female
			</td>
		</tr>
		<tr>
			<td>Role :</td>
			<td><form:select path="role">
					<form:option value="NONE" label="Select Role" />
					<form:options items="${roleList}" />
				</form:select></td>
		</tr>
		<tr>
			<td><form:label path="communication_language">Communication Language</form:label></td>
			<td><form:select path="communication_language"
					items="${communication_languagesList}" multiple="true" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Edit Save" /></td>
		</tr>
	</table>
</form:form>
