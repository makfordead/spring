package com.hh.store.service;

import com.hh.store.entity.user;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class serviceImpl {


    private EntityManager entityManager;

    @Autowired
    public  serviceImpl(EntityManager entityManager) {
        this.entityManager= entityManager;
    }

    @Transactional
    public void save(user theUser)
    {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theUser);


    }
    @Transactional
    public List<user>  getusers()
    {
        Session session = entityManager.unwrap(Session.class);
        Query<user> theQuery = session.createQuery("from user",user.class);
        List<user> r = theQuery.getResultList();
        return r;
    }

}
