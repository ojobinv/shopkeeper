package dev.ovj.shopkeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ovj.shopkeeper.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
