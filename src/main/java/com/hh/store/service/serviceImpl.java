package com.hh.store.service;

import com.hh.store.entity.Image;
import com.hh.store.entity.UserEntity;
import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.File;
import java.util.Base64;
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
    @Transactional
    public UserEntity LoginAuthen(String username , String password)
    {
        Session session = entityManager.unwrap(Session.class);
        Query<UserEntity> theQuery = session.createQuery("from UserEntity U WHERE U.username = :username and U.password = :password");
        theQuery.setParameter("username" , username);
        theQuery.setParameter("password", password);
        UserEntity theUser = new UserEntity();
        try {
             theUser = theQuery.setMaxResults(1).getSingleResult();

        }
        catch (Exception e)
        {
            System.out.println("!!!returning null object!!!");
        }



        return theUser;

           }
           @Transactional
    public Image save(Image image)
           {
               Session session = entityManager.unwrap(Session.class);
               session.saveOrUpdate(image);

//               byte[] decodedBytes = Base64.getDecoder().decode(image.getImage64converted());
//               try {
//                   FileUtils.writeByteArrayToFile(new File("image1"), decodedBytes);
//
//               }

//               catch (Exception e)
//               {
//                   System.out.println("there is an error");
//               }
               return image;
           }
    @Transactional
    public List<Image> getImages()
    {
        Session session= entityManager.unwrap(Session.class);
        Query<Image> theQuery = session.createQuery("from Image", Image.class);
        List<Image> r = theQuery.getResultList();
        return r;
    }

    @Transactional
    public List<Image> getImagebyUsername(String username)
    {

        Session session = entityManager.unwrap(Session.class);
                Query<Image> theQuery = session.createQuery("from Image d Where d.username =: username");
                theQuery.setParameter("username",username);
                List<Image> theList = theQuery.getResultList();
                return theList;
    }

    @Transactional
    public boolean deleteImage(String id, String Username)
    {
        Session session = entityManager.unwrap(Session.class);

            Image img = session.get(Image.class,Integer.parseInt(id));

        if(img==null || !img.getUsername().equals(Username))
             return false;
            else {
         session.delete(img);
            return true;
        }
//            Query<Image> theQuery = session.createQuery("delete from Image d Where d.id =:id and d.username =:username");
//            theQuery.setParameter("id",Integer.parseInt(id));
//            theQuery.setParameter("username",Username);
//            theQuery.executeUpdate();
//            return true;


    }
}
