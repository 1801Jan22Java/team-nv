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
@Table(name="Users")
public class Users implements Serializable {
    
//_____________________________________________Column Names____________________________________________________________________________

    public Users() {
        super();
    }
    
    
    
    
public Users(String firstName, String lastName, String email, String username, String password) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }




//_____________________________________________Column Names____________________________________________________________________________
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="User_IdSequence")
    @SequenceGenerator(allocationSize=1,name="User_IdSequence",sequenceName="SQ_UserId_PK")
    @Column(name="User_Id")
    private int id;

    @Column(name="FIRSTNAME")
    private String firstName;
    @Column(name="LASTNAME")
    private String lastName;
    @Column(name="EMAIL")
    private String email;
    @Column(name="USERNAME")
    private String username;
    @Column(name="PASSWORD")
    private String password;

//_____________________________________________Mapping Join____________________________________________________________________________
    //need a many to many  to many between users and groups
    // need a many to many between users and flashcards
    // need a many to many with progress 
    
    //@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    //private Group groups;
    
    //private User users;
    //@ManyToMany(mappedBy = "Group") 
    //List<User> users = new ArrayList<User>();
    
    //@JoinTable(name ="GROUPUSER", joinColumns =@JoinColumn(name="user_id"),inverseJoinColumns =@JoinColumn(name="group_id"))
    //private List<User> groups = new ArrayList<User>();
    

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinTable(
            name = "USERS_GROUPS", 
            joinColumns = { @JoinColumn(name = "User_Id") }, 
            inverseJoinColumns = { @JoinColumn(name = "Group_Id") }
        )
    private Collection<Group> groups = new ArrayList();
    
//_____________________________________________Getters/Setters____________________________________________________________________________
    /*
    public void addPeople (User p) {
        users.add(p);
    }
    
    public List<User> getPeople(){
        return users;
    }
    
    */

    public Collection<Group> getUsers() {
        return groups;
    }




    public void setUsers(Group groups) {
        this.groups.add(groups);
    }




    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


//_____________________________________________To String____________________________________________________________________________
    
    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", username=" + username + ", password=" + password + "]";
    }




    public List<Group> getGroup() {
        // TODO Auto-generated method stub
        return null;
    }    

}