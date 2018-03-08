package com.revature.messages;

import com.revature.beans.Progress;

public class ProgressUpdated {
	public ProgressUpdated(Boolean isAdded) {
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
