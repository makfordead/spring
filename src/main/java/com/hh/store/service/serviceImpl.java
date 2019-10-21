package com.hh.store.service;

import com.hh.store.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(UserEntity theUserEntity)
    {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theUserEntity);


    }
    @Transactional
    public List<UserEntity>  getusers()
    {
        Session session = entityManager.unwrap(Session.class);
        Query<UserEntity> theQuery = session.createQuery("from UserEntity", UserEntity.class);
        List<UserEntity> r = theQuery.getResultList();
        return r;
    }

}
