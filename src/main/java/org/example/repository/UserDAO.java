package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.constant.ErrorMessage;
import org.example.domain.model.UserModel;
import org.example.utils.HibernateUtils;
import org.hibernate.Hibernate;

public class UserDAO {

    private EntityManager getEntityManager(){
        return HibernateUtils.getEntityManager();
    }
    
    public void create(UserModel userModel){
        EntityManager en=  getEntityManager();
        try{
            en.getTransaction().begin();
            en.persist(userModel);
            en.getTransaction().commit();
        }catch (Exception e){
            throw new RuntimeException(ErrorMessage.User.ERR_CREATE_USER);
        } finally{
            en.close();
        } 
    }
    
    public void update(Long id, UserModel userModel){
        EntityManager en=  getEntityManager();
        try{
            en.getTransaction().begin();
            UserModel um= en.find(UserModel.class,id);
           if (um == null) {
                throw new RuntimeException(String.format(ErrorMessage.User.ERR_GET_BY_ID_USER, id));
            }
            um.setUsername(userModel.getUsername());
            um.setAddress(userModel.getAddress());
            um.setEmail(userModel.getEmail());
            um.setFullName(userModel.getFullName());
            um.setCreatedAt(userModel.getCreatedAt());
            um.setPhoneNumber(userModel.getPhoneNumber());
            um.setPassword(userModel.getPassword());
            um.setUpdatedAt(userModel.getUpdatedAt());
            um.setStatus(userModel.getStatus());
            en.merge(um);
            en.getTransaction().commit();
        } catch (RuntimeException e) {
            if (en.getTransaction().isActive()) {
                en.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException(String.format(ErrorMessage.User.ERR_UPDATE_USER, id));
        } finally {
            en.close();
        } 
    }
    
    public UserModel getUserById(Long id){
        EntityManager en= getEntityManager();
        
        try{
            en.getTransaction().begin();
            UserModel userModel= en.find(UserModel.class, id);
            en.getTransaction().commit();
            if(userModel==null){
                throw new RuntimeException(String.format(ErrorMessage.User.ERR_GET_BY_ID_USER, id));
            }
            return userModel;
            
        } catch(RuntimeException e){
                throw new RuntimeException(String.format(ErrorMessage.User.ERR_GET_BY_ID_USER, id));
        }finally{
            en.close();
        }
    }
    
    
}

