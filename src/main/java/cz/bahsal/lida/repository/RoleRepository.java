package cz.bahsal.lida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.bahsal.lida.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
