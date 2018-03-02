package beans;

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

	public PendingFlashcard(int flashcardId, int groupId) {
		super();
		this.flashcardId = flashcardId;
		this.groupId = groupId;
	}

	//These are simply  references in a table to the flash cards that are yet to be connected to a group
	//Once a flash card has been rejected or accepted, the reference should be deleted from this table

	@Column(name="FLASHCARD_ID")
    private int flashcardId;
	
	@Column(name = "GROUP_ID")
    private int groupId;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Pending_Flashcard_IdSequence")
	@SequenceGenerator(allocationSize=1,name="Pending_Flashcard_IdSequence",sequenceName="SQ_Pending_Flashcard_PK")
	@Column(name="Pending_Flashcard_Id")
	private int id;
	
	public int getFlashcardId() {
		return flashcardId;
	}

	public void setFlashcardId(int flashcardId) {
		this.flashcardId = flashcardId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	public String toString() {
		return "FlashcardId: "+this.flashcardId+" GroupId: "+this.groupId;
	}
}
