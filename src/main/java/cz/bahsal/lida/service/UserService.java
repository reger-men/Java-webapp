package cz.bahsal.lida.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.bahsal.lida.entity.Blog;
import cz.bahsal.lida.entity.Item;
import cz.bahsal.lida.entity.User;
import cz.bahsal.lida.repository.BlogRepository;
import cz.bahsal.lida.repository.ItemRepository;
import cz.bahsal.lida.repository.UserRepository;

@Service
public class UserService {

		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private BlogRepository blogRepository;
		
		@Autowired
		private ItemRepository itemRepository;
		
		
		public List<User> findAll(){
			return userRepository.findAll();
		}

		public User findOne(int id) {
			return userRepository.findOne(id);
		}

		@Transactional
		public User findOneWithBlogs(int id) {
			User user= findOne(id);
			List<Blog> blogs = blogRepository.findByUser(user);
			for(Blog blog : blogs){
				List<Item> items = itemRepository.findByBlog(blog);
				blog.setItems(items);
			}
			user.setBlogs(blogs);
			return user;
		}
}