package com.revature.beans;

import javax.persistence.*;

import com.revature.beans.Tag;
@Entity
@Table(name = "PROGRESS")
public class Progress {
	public Progress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Progress(Tag tag, Users u) {
		super();
		this.total = 0;
		this.numCorrect = 0;
		this.tag = tag;
		this.user=u;
	}

	//This is the PK value for the progress table and the sequence that generates it
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="progressSequence")
	@SequenceGenerator(allocationSize=1,name="progressSequence",sequenceName="SQ_PROGRESS_PK")
	@Column(name="PRORESS_ID")
	private int progressId;
	
	@Column
	private int total;
	
	@Column
	private int numCorrect;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TAG_ID")
	private Tag tag;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_ID")
	private Users user;

	public int getProgressId() {
		return progressId;
	}

	public void setProgressId(int progressId) {
		this.progressId = progressId;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNumCorrect() {
		return numCorrect;
	}

	public void setNumCorrect(int numCorrect) {
		this.numCorrect = numCorrect;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
	public String toString(){
		return this.tag+" "+this.user.toString();
	}
}
