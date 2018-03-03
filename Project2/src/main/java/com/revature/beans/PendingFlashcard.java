package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PENDING_FLASHCARDS")
public class PendingFlashcard {
	
	public PendingFlashcard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PendingFlashcard(Flashcard flashcard, Group group) {
		super();
		this.flashcard = flashcard;
		this.group = group;
	}

	//These are simply  references in a table to the flash cards that are yet to be connected to a group
	//Once a flash card has been rejected or accepted, the reference should be deleted from this table

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FLASHCARD")
    private Flashcard flashcard;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GROUPS")
    private Group group;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Pending_Flashcard_IdSequence")
	@SequenceGenerator(allocationSize=1,name="Pending_Flashcard_IdSequence",sequenceName="SQ_Pending_Flashcard_PK")
	@Column(name="Pending_Flashcard_Id")
	private int id;
	
	public Flashcard getFlashcardId() {
		return flashcard;
	}

	public void setFlashcard(Flashcard flashcard) {
		this.flashcard = flashcard;
	}

	public Group getGroupId() {
		return group;
	}

	public void setGroupId(Group groupId) {
		this.group = groupId;
	}
	
	public String toString() {
		return "FlashcardId: "+this.flashcard.getFlashcardId()+" GroupId: "+this.group.getId();
	}

}

