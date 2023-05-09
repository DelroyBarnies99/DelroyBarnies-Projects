package com.barnies.springboot.webapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.barnies.springboot.webapp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByEmail(String email);

}
