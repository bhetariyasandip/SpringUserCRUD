<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Employee</h1>
<form:form method="post" action="save">
	<table>
		<tr>
			<td><form:label path="First_name">First Name</form:label></td>
			<td><form:input path="First_name" placeholder="Enter First Name" /></td>
		</tr>
		<tr>
			<td><form:label path="Middle_name">Middle Name</form:label></td>
			<td><form:input path="Middle_name"
					placeholder="Enter Middle Name" /></td>
		</tr>
		<tr>
			<td><form:label path="Last_name">Last Name</form:label></td>
			<td><form:input path="Last_name" placeholder="Enter Last Name" /></td>
		</tr>
		<tr>
			<td><form:label path="gender">Gender</form:label></td>
			<td>
				<%-- <form:input path="Gender" placeholder="Enter Gender" />--%> <form:radiobutton
					path="Gender" value="Male" />Male <form:radiobutton path="Gender"
					value="Female" />Female
			</td>
		</tr>
		<tr>
			<td><form:label path="role">Role</form:label></td>
			<td><form:select path="role">
					<form:option value="NONE" label="Select Role" />
					<form:options items="${roleList}" />
				</form:select></td>
		</tr>
		<tr>
			<td><form:label path="communication_language">Communication Language</form:label></td>
			<td><form:select path="communication_language" items="${communication_languagesList}"
					multiple="true" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>
