package com.tekbasic.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tekbasic.entity.User;
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("from User u where u.username = :username")
    public Optional<User> findByUsername(@Param("username") String username);
	@Modifying
	@Query("update User u set u.name=:name,u.email=:email,u.address=:address where u.id=:id")
	public void updateUser(@Param("name")String name,@Param("email")String email,
			@Param("address")String address,@Param("id")int id);

}
