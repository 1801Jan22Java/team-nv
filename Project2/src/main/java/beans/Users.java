package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.Serializable;
import javax.persistence.*;

import beans.*;


@Entity
@Table(name="USERS")
public class Users implements Serializable {
    
//_____________________________________________Column Names____________________________________________________________________________

    public Users() {
        super();
    }
    
    
    
    
public Users(String id) {
        super();
        this.id = id;
    }




//_____________________________________________Column Names____________________________________________________________________________
    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="User_IdSequence")
    //@SequenceGenerator(allocationSize=1,name="User_IdSequence",sequenceName="SQ_UserId_PK")
    @Column(name="USER_ID")
    private String id;



//_____________________________________________Mapping Join____________________________________________________________________________
/*
 * These relationship mappings create tables within our database for creating the needed many-to-many relationships between them
 * each relationship requires a new joining table, and are used in conjunction with the related collection to add entities
 */
  
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinTable(
            name = "USERS_GROUPS", 
            joinColumns = { @JoinColumn(name = "User_Id") }, 
            inverseJoinColumns = { @JoinColumn(name = "Group_Id") }
        )
    private Collection<Group> groups = new ArrayList();
    
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinTable(
            name = "USERS_FLASHCARDS", 
            joinColumns = { @JoinColumn(name = "User_Id") }, 
            inverseJoinColumns = { @JoinColumn(name = "Flashcard_Id") }
        )
    private Collection<Flashcard> flashcards = new ArrayList();
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinTable(
            name = "USERS_TAGS", 
            joinColumns = { @JoinColumn(name = "User_Id") }, 
            inverseJoinColumns = { @JoinColumn(name = "Tag_Id") }
        )
    private Collection<Tag> tags = new ArrayList();
    
//_____________________________________________Getters/Setters____________________________________________________________________________
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 /* 
  * These getters & Setters allow us to add tags, flashcards, and groups in association with the user  
  * The get methods will retrieve the associated entity and add the connection to them in the join table for later retrieval
 */ 
	public Collection<Group> getGroups() {
		return groups;
	}

	public void setGroups(Collection<Group> groups) {
		this.groups = groups;
	}

	public Collection<Flashcard> getFlashcards() {
		return flashcards;
	}

	public void setFlashcards(Collection<Flashcard> flashcards) {
		this.flashcards = flashcards;
	}
	
	public Collection<Tag> getTags() {
		return tags;
	}

	public void setTags(Collection<Tag> tags) {
		this.tags = tags;
	}
//_____________________________________________To String____________________________________________________________________________
    
    @Override
    public String toString() {
        return "User [id=" + id +"]";
    }

}