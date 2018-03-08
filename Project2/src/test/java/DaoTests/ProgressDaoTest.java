package DaoTests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.beans.Progress;
import com.revature.beans.Tag;
import com.revature.dao.FlashcardDaoImpl;
import com.revature.dao.ProgressDaoImpl;
import com.revature.dao.TagDaoImpl;
import com.revature.dao.UsersDaoImpl;

public class ProgressDaoTest {
	
	static TagDaoImpl tdi = new TagDaoImpl();	
	static UsersDaoImpl udi = new UsersDaoImpl();
	static FlashcardDaoImpl fcdi = new FlashcardDaoImpl();
	static ProgressDaoImpl pdi = new ProgressDaoImpl();
	
	//@Test
	/*
	public void addProgressTest() {
		pdi.addProgress(new Progress(tdi.getTag(101),udi.getUser("userTest2")));
		//assertNotNull(temp);
	}*/
}
