package com.revature.messages;

public class UserAdded {
	public UserAdded(Boolean isAdded) {
		super();
		this.isAdded = isAdded;
	}

	private Boolean isAdded;

	public Boolean getIsValidated() {
		return isAdded;
	}

	public void setIsValidated(Boolean isAdded) {
		this.isAdded = isAdded;
	}
	
}
