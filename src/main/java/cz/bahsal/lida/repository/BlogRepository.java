package cz.bahsal.lida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.bahsal.lida.entity.Blog;


public interface BlogRepository extends JpaRepository<Blog, Integer>{

}
