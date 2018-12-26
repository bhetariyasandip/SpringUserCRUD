package com.nexp.beans;

public class Emp {
	private int id;
	private String First_name, Middle_name, Last_name, Gender,communicationlanguage;
	private String role;
	private String [] communication_language;
	private int Pagination;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return Gender;
	}	

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getMiddle_name() {
		return Middle_name;
	}

	public void setMiddle_name(String middle_name) {
		Middle_name = middle_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String [] getCommunication_language() {
		return communication_language;
	}

	public void setCommunication_language(String [] communication_language) {
		this.communication_language = communication_language;
	}

	public String getCommunicationlanguage() {
		return communicationlanguage;
	}

	public void setCommunicationlanguage(String communicationlanguage) {
		this.communicationlanguage = communicationlanguage;
	}

	public int getPagination() {
		return Pagination;
	}

	public void setPagination(int pagination) {
		Pagination = pagination;
	}

	

}
