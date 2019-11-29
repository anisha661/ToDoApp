package com.project.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.todo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
