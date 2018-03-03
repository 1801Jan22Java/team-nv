package com.revature.beans;

import javax.persistence.*;

@Entity
@Table
public class Tag {
	
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tag(String tagName) {
		super();
		this.tagName = tagName;
	}
	//This is the primary key generated from a sequence and the foreign key to the progress table
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TagSequence")
	@SequenceGenerator(allocationSize=1,name="TagSequence",sequenceName="SQ_TAG_PK")
	@Column(name="TAG_ID")
	private int id;
	//The name is the actual string value of the tag, ie. fractions, biology, etc.
	@Column(name="ANIMAL_NAME")
	private String tagName;
	//Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String toString() {
		return this.tagName;
	}
}
