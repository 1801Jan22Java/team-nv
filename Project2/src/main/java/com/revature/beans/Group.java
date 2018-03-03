package com.revature.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.Serializable;
import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.beans.*;

@Component("group")
@Entity
@Scope("prototype")
@Table(name = "GROUP_TABLE")
public class Group {
    
    public Group(String groupName, String groupDescription, Users groupLeader) {
		super();
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.groupLeader = groupLeader;
	}




	public Group(String groupName, Users groupLeader) {
		super();
		this.groupName = groupName;
		this.groupLeader = groupLeader;
	}




	public Group() {
        super();
    }
    
//_____________________________________________Column Names____________________________________________________________________________
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Group_IdSequence")
    @SequenceGenerator(allocationSize=1,name="Group_IdSequence",sequenceName="SQ_Group_PK")
    @Column(name="GROUP_ID")
    private int id;
    
    @Column(name="GROUPNAME")
    private String groupName;
    
    @Column(name="GROUP_DESCRIPTION")
    private String groupDescription;
    
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<PendingFlashcard> pendingFlashcards;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUPLEADER_ID")
    private Users groupLeader;
    
    @ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JoinTable(
            name = "GROUP_FLASHCARDS", 
            joinColumns = { @JoinColumn(name = "Group_Id") }, 
            inverseJoinColumns = { @JoinColumn(name = "Flashcard_Id") }
        )
    private Collection<Flashcard> flashcards = new ArrayList();

//_____________________________________________Mapping Join____________________________________________________________________________

    // need a foreign key to a userid which will be the leaderid
    @ManyToMany(mappedBy ="groups")    
    private Collection<Users> users = new ArrayList();
    
     // List <User> groups = new ArrayList<>();
    /*
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinColumn(name="User_Id")
    private List<User> users;
     */ 
    //public Object getUsers;
    
    
//_____________________________________________Getters/Setters____________________________________________________________________________

    public int getId() {
        return id;
    }

    public Collection getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users.add(users);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


//_____________________________________________To String____________________________________________________________________________

    @Override
    public String toString() {
        return "Group [id=" + id + ", groupName=" + groupName + "]";
    }




	public String getGroupDescription() {
		return groupDescription;
	}




	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}




	public Users getGroupLeader() {
		return groupLeader;
	}




	public void setGroupLeader(Users groupLeader) {
		this.groupLeader = groupLeader;
	}




	public Collection<Flashcard> getFlashcards() {
		return flashcards;
	}




	public void setFlashcards(Collection<Flashcard> flashcards) {
		this.flashcards = flashcards;
	}




	public void setUsers(Collection<Users> users) {
		this.users = users;
	}




	public Collection<PendingFlashcard> getPendingFlashcards() {
		return pendingFlashcards;
	}




	public void setPendingFlashcards(Collection<PendingFlashcard> pendingFlashcards) {
		this.pendingFlashcards = pendingFlashcards;
	}




}