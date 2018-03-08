export interface Group {
    groupId: number;
    groupName: string;
    groupDescription: string;
    groupLeader: string;
}

/*
    private int id;
    
    @Column(name="GROUPNAME")
    private String groupName;
    
    @Column(name="GROUP_DESCRIPTION")
    private String groupDescription;
    
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<PendingFlashcard> pendingFlashcards;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GROUPLEADER_ID")
    private Users groupLeader;
    
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinTable(
            name = "GROUP_FLASHCARDS", 
            joinColumns = { @JoinColumn(name = "Group_Id") }, 
            inverseJoinColumns = { @JoinColumn(name = "Flashcard_Id") }
        )
    private Collection<Flashcard> flashcards = new ArrayList();
*/