package cz.bahsal.lida.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.bahsal.lida.entity.Blog;
import cz.bahsal.lida.entity.Item;


public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByBlog(Blog blog);

}
