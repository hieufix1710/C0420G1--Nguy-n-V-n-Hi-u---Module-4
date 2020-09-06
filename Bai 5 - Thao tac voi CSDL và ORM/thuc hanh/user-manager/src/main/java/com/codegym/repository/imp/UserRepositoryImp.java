package com.codegym.repository.imp;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepositoryImp implements UserRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<User> findAll() {
        TypedQuery<User> listUser = em.createQuery("select c from User c", User.class);
        System.out.println(listUser.getResultList().size());
        return listUser.getResultList();
    }

    @Override
    public User findOne(Long id) {
         TypedQuery<User> listUser = em.createQuery("select c from User c where c.id=:id" , User.class);
                listUser.setParameter("id",id);

                return listUser.getSingleResult();
    }

    @Override
    public User save(User customer) {
        System.out.println(customer.toString());
        if (Integer.valueOf(customer.getId())!=null){
            em.merge(customer); // update
        }else {
            em.persist(customer); //insert
        }
        return customer;
    }

    @Override
    public List<User> save(List<User> customers) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<User> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {
             em.remove(id);
    }

    @Override
    public void delete(User customer) {

    }

    @Override
    public void delete(List<User> customers) {

    }

    @Override
    public void deleteAll() {

    }
}
