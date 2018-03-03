package com.revature.messages;

public class UserValidation {
	public UserValidation(Boolean isValidated) {
		super();
		this.isValidated = isValidated;
	}

	private Boolean isValidated;

	public Boolean getIsValidated() {
		return isValidated;
	}

	public void setIsValidated(Boolean isValidated) {
		this.isValidated = isValidated;
	}
	
}
