package com.revature.messages;

import com.revature.beans.Progress;

public class ProgressMessage {
	public ProgressMessage(Progress p) {
		super();
		this.tagName = p.getTag().getTagName();
		this.numCorrect = p.getNumCorrect();
		this.total = p.getTotal();
	}
	private String tagName;
	private int numCorrect;
	private int total;
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public int getNumCorrect() {
		return numCorrect;
	}
	public void setNumCorrect(int numCorrect) {
		this.numCorrect = numCorrect;
	}
	public int getNumAnswered() {
		return total;
	}
	public void setNumAnswered(int numAnswered) {
		this.total = numAnswered;
	}

}
