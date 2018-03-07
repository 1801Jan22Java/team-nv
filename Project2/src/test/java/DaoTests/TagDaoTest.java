package DaoTests;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.revature.beans.Group;
import com.revature.beans.Tag;
import com.revature.beans.Users;
import com.revature.dao.TagDaoImpl;
import com.revature.util.HibernateUtil;

public class TagDaoTest {
	
	static TagDaoImpl tdi = new TagDaoImpl();
	
	@Test
	public void addTagTest() {
		Tag tag = new Tag("test");
		Tag temp = null;
		tdi.addTag(tag);
		for(Tag t: tdi.getAllTags())
		{
			if(t.getTagName().equals("test"));
			{
				temp = t;
			}
		}
		assertNotNull(temp);
	}
}
