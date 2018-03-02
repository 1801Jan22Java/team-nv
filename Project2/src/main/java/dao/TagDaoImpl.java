package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Flashcard;
import beans.Tag;
import util.HibernateUtil;

import java.util.List;

import beans.Tag;

public class TagDaoImpl {
	public List<Tag> getAllTags() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from Tag");
		List<Tag> items = q.list();
		s.close();
		return items;
	}



	public void addTag(Tag t) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(t);
		tx.commit();
		s.close();
		
	}

	public void deleteTag(int tagId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Tag tag = (Tag)s.get(Tag.class, tagId);
		s.delete(tag);
		tx.commit();
		s.close();
	}

	public int changeTag(int tagId, String tagName) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Tag tag = (Tag)s.get(Tag.class, tagId);
		tag.setTagName(tagName);
		tx.commit();
		s.close();
		return 1;
	}
}
