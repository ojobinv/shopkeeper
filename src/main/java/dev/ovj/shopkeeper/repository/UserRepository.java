package dev.ovj.shopkeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ovj.shopkeeper.entity.Role;
import dev.ovj.shopkeeper.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
