package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.*;

public interface UsersDao {
    public Users getUser(String UserId);
    public void addUser(String userId);
    public void addUser(Users u);
}