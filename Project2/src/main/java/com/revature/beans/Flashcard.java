package com.revature.beans;

import javax.persistence.*;

import com.revature.beans.Tag;

@Entity
@Table(name = "FLASHCARD")
public class Flashcard {
public Flashcard(String question, String answer, String hint, Tag tag) {
		super();
		this.flashcardId = flashcardId;
		Question = question;
		Answer = answer;
		Hint = hint;
		this.tag = tag;
	}

// Columns
	
	public Flashcard() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Flashcard_IdSequence")
    @SequenceGenerator(allocationSize=1,name="Flashcard_IdSequence",sequenceName="SQ_Flashcard_PK")
    @Column(name="FLASHCARD_ID")
	private int flashcardId;
	
	@Column(name="QUESTION")
	private String Question;
	
	@Column(name ="ANSWER")
	private String Answer;
	
	@Column(name = "HINT")
	private String Hint;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TAG")
	private Tag tag;
	
//Getters & Setters
	public int getFlashcardId() {
		return flashcardId;
	}

	public void setFlashcardId(int flashcardId) {
		this.flashcardId = flashcardId;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public String getHint() {
		return Hint;
	}

	public void setHint(String hint) {
		Hint = hint;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
	public String toString() {
		return this.Question+" "+this.Hint+" "+this.Answer;
	}
}
