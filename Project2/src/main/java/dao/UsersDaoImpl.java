package dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import beans.*;
public class UsersDaoImpl implements UsersDao{

	@Override
	public Users getUser(String UserId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Users u = (Users)s.get(Users.class, UserId);
		tx.commit();
		s.close();
		return u;
	}

	@Override
	public void addUser(String userId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Users u = new Users(userId);
		s.save(u);
		tx.commit();
		s.close();
	}

	@Override
	public void addUser(Users u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		s.save(u);
		tx.commit();
		s.close();
	}
 
    
    
}