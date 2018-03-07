package com.revature.messages;

public class GroupAddedFlashcard {
	public GroupAddedFlashcard(Boolean isAdded) {
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
