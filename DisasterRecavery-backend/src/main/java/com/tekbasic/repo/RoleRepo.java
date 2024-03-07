package com.tekbasic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tekbasic.entity.Role;
@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
	@Modifying
	@Transactional
	@Query("update Role r set r.role=:role where r.id=:id")
	public void updateRole(@Param("role")String role,@Param("id")int id);
}
