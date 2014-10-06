package cz.bahsal.lida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.bahsal.lida.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
