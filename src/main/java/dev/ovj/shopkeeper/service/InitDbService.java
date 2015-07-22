package dev.ovj.shopkeeper.service;


import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ovj.shopkeeper.entity.Role;
import dev.ovj.shopkeeper.entity.User;
import dev.ovj.shopkeeper.repository.RoleRepository;
import dev.ovj.shopkeeper.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setRole_name("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setRole_name("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setPassword("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
	}
}
