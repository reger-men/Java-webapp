package cz.bahsal.lida.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.bahsal.lida.entity.Blog;
import cz.bahsal.lida.entity.Item;
import cz.bahsal.lida.entity.Role;
import cz.bahsal.lida.entity.User;
import cz.bahsal.lida.repository.BlogRepository;
import cz.bahsal.lida.repository.ItemRepository;
import cz.bahsal.lida.repository.RoleRepository;
import cz.bahsal.lida.repository.UserRepository;

@Service
@Transactional
public class UserService {

		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private BlogRepository blogRepository;
		
		@Autowired
		private ItemRepository itemRepository;
		
		@Autowired
		private RoleRepository roleRepository;
		
		
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

		public void save(User user) {
			user.setEnabled(true);
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByName("ROLE_USER"));
			user.setRoles(roles);
			
			userRepository.save(user);
			
		}
}
