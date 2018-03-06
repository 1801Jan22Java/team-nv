package DaoTests;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;
import com.revature.beans.Tag;
import com.revature.beans.Users;
import com.revature.dao.GroupDaoImpl;
import com.revature.util.HibernateUtil;

public class GroupDaoTest {
	
	public static GroupDaoImpl groupDao = new GroupDaoImpl();
	public static DataBaseDriver driver = new DataBaseDriver();
	//@Test
	public void addGroupTest() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Group g = new Group("Group name","Desctiption",(Users)s.get(Users.class, "temp1"));
		groupDao.addGroup(g);
		int groupId = g.getId();
		Group temp = (Group)s.get(Group.class, groupId);
		assertNotNull(temp);
		s.close();
	}
	//@Test
	public void getGroupFlashcardTest() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Group g = new Group("Group name","Desctiption",(Users)s.get(Users.class, "temp1"));
		Tag tag = new Tag("goupTest");
		Flashcard fc = new Flashcard("q","h","a",tag);
		s.persist(tag);
		s.persist(fc);
		s.persist(g);
		g.getFlashcards().add(fc);
		int groupId = g.getId();
		tx.commit();
		s.close();
		Collection<Flashcard>test = groupDao.getGroupFlashcards(groupId);
		assertNotNull(test);
	}
	//@Test
	public void getGroupUsersTest() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Users u = (Users)s.get(Users.class, "temp1");
		Group g = new Group("Group name","Desctiption",u);
		Tag tag = new Tag("goupTest");
		s.persist(tag);
		s.persist(g);
		g.getUsers().add(u);
		int groupId = g.getId();
		tx.commit();
		s.close();
		Collection<Users>test = groupDao.getGroupsUsers(groupId);
		assertNotNull(test);
	}
	@Test
	public void getAllGroupsTest() {
		//driver.create();
		Collection<Group> test = groupDao.getAllGroups();
		System.out.println(test);
		assertNotNull(test);
	}
	//@Test
	public void getGroupByIdTest() {
		Group test = groupDao.getGroupById(1);
		System.out.println(test);
		assertNotNull(test);
	}
}
