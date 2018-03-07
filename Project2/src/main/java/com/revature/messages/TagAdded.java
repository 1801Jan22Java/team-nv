package com.revature.messages;

public class TagAdded {
	public TagAdded(Boolean isAdded) {
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
