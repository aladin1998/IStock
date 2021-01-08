package com.javatechie.jpa.service;

import com.javatechie.jpa.entity.Product;

import com.javatechie.jpa.entity.User;
import com.javatechie.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    public User saveUser(User user) {

        return repository.save(user);

    }


    public List<User> saveUsers(List<User> users) {
 int test=0;

            for(User user:users){
                if(user.getRole()==2)
                    repository.save(user);
                else test=1;
            }
       if(test==0) return users;
       else return null;

    }
    public Long login(String email,String mdp){
        return repository.countLogin(email,mdp);
    }

    public List<User> getUsers() {
        return repository.getChefs();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        return repository.findByName(name);
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public String deleteUser(Long id) {
        repository.deleteById(id);
        return "User removed !! " + id;
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setPrenom(user.getPrenom());
        existingUser.setCni(user.getCni());
        existingUser.setRole(user.getRole());
        existingUser.setTel(user.getTel());
        existingUser.setMdp(user.getMdp());
        return repository.save(existingUser);
    }

}