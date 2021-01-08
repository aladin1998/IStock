package com.javatechie.jpa.repository;


import com.javatechie.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
    User findByEmail(String email);

    @Query(value="SELECT * FROM utilisateur WHERE ROLE_USR=1",nativeQuery=true)
      List<User> getChefs();

    @Query("SELECT COUNT(u) FROM User u WHERE u.email=?1 AND u.mdp=?2")
    Long countLogin(String email,String mdp);
}
