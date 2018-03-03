package com.revature.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.*;

public interface UsersDao {
    public Users getUser(String UserId);
    public void addUser(String userId);
    public void addUser(Users u);
    public Collection<Flashcard> getUsersFlashcards(String userId);
    public Collection<Group> getUsersGroups(String userId);
}