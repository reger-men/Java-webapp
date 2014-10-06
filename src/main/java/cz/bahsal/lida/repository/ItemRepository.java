package cz.bahsal.lida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.bahsal.lida.entity.Item;


public interface ItemRepository extends JpaRepository<Item, Integer>{

}
