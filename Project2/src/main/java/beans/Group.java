package beans;

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
import beans.*;

@Entity
<<<<<<< HEAD
@Table(name = "GROUP_TABLE")
// GROUP IS A KEYWORD
public class Group {
    
    public Group(String groupName, Users groupLeader) {
		super();
		this.groupName = groupName;
		this.groupLeader = groupLeader;
	}




	public Group() {
=======
@Table(name = "GROUPTable")
// GROUP IS A KEYWORD
public class Group {
    
    public Group() {
>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5
        super();
    }
    
//_____________________________________________Column Names____________________________________________________________________________
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Group_IdSequence")
    @SequenceGenerator(allocationSize=1,name="Group_IdSequence",sequenceName="SQ_Group_PK")
    @Column(name="Group_Id")
    private int id;
    
    @Column(name="GROUPNAME")
    private String groupName;
<<<<<<< HEAD
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GROUPLEADER_ID")
    private Users groupLeader;
    
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinTable(
            name = "GROUP_FLASHCARDS", 
            joinColumns = { @JoinColumn(name = "Group_Id") }, 
            inverseJoinColumns = { @JoinColumn(name = "Flashcard_Id") }
        )
    private Collection<Group> flashcards = new ArrayList();
=======


>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5

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
<<<<<<< HEAD
=======
/*
    public void addGroup (User p) {
        groups.add(p);
    }
    
    public List<User> getGroup(){
        return groups;
    }
    */
    
    /*
public List<User> getPeople() {
        return people;
    }




    public void setPeople(List<User> people) {
        this.people = people;
    }

*/
/*
    public List<Group> getGroups() {
        return groups;
    }




    public void setGroups(Group groups) {
        this.groups.add(groups);
    }

*/

>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5

    public int getId() {
        return id;
    }

<<<<<<< HEAD
=======



>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5
    public Collection getUsers() {
        return users;
    }

<<<<<<< HEAD
=======



>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5
    public void setUsers(Users users) {
        this.users.add(users);
    }

<<<<<<< HEAD
=======



>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5
    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD
=======



>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5
    public String getGroupName() {
        return groupName;
    }

<<<<<<< HEAD
=======



>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


//_____________________________________________To String____________________________________________________________________________

    @Override
    public String toString() {
        return "Group [id=" + id + ", groupName=" + groupName + "]";
    }




}