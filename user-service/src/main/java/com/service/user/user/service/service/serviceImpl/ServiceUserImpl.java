package com.service.user.user.service.service.serviceImpl;

import com.service.user.user.service.entity.User;
import com.service.user.user.service.exceptions.UserException;
import com.service.user.user.service.repository.RepositoryUser;
import com.service.user.user.service.service.ServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ServiceUserImpl implements ServiceUser {

    @Autowired
    private RepositoryUser repositoryUser;

    @Override
    public User createUser(User user) {
        User userModel = repositoryUser.findByEmail(user.getEmail());
        if (userModel != null ) {
            throw new RuntimeException("User already exists");
        }
        return repositoryUser.save(user);
    }

    @Override
    @Transactional
    public boolean deleteUserById(Long id) {
        User userModel = repositoryUser.findUserById(id);
        if( userModel != null ){
            repositoryUser.delete(userModel);
            System.out.println("user with ID : "+id+" deleted succées !");
            return true;
        }else{
            System.out.println("user with ID : "+id+" exist !");
            return false;
        }
    }

    @Override
    public User getUserById(Long id) {
        return repositoryUser.findById(id).orElseThrow(()-> new UserException("user with ID :"+id+" not found !"));
    }

    @Override
    public User getUserByName(String name) {
        User userModel = repositoryUser.findByUserNameIgnoreCase(name);
        if( userModel != null ){
            return userModel;
        }else{
            System.out.println("user with userName : "+name+" not found");
            return null;
        }
    }

    @Override
    public List<User> getAllUsers(){
        return repositoryUser.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User userModel = repositoryUser.findUserById(id);
        if ( userModel != null ){
            mapToEntity(userModel,user);
            repositoryUser.save(userModel);
            System.out.println("update user with ID : "+id+" succées !");
        }else{
            System.out.println("user with ID : "+id+" not found !");
        }
        return userModel;
    }

    public void mapToEntity(User userEntry, User userUpdated){
        userUpdated.setId(userEntry.getId());
        userUpdated.setUserName(userEntry.getUserName());
        userUpdated.setEmail(userEntry.getEmail());
        userUpdated.setPassword(userEntry.getPassword());
        userUpdated.setRole(userEntry.getRole());
    }
}
