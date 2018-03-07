export interface Flashcard {
    flashcardId: number;
    Question: String;
    Answer: String;
    groupLeader: String;
    tag: String;

/*    @Column(name="FLASHCARD_ID")
	private int flashcardId;
	
	@Column(name="QUESTION")
	private String Question;
	
	@Column(name ="ANSWER")
	private String Answer;
	
	@Column(name = "HINT")
	private String Hint;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TAG")
	private Tag tag; */
}