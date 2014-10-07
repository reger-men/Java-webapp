package cz.bahsal.lida.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.bahsal.lida.entity.Blog;
import cz.bahsal.lida.entity.User;


public interface BlogRepository extends JpaRepository<Blog, Integer>{

		List<Blog> findByUser(User user);
}
