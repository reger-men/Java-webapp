package cz.bahsal.lida.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;






import cz.bahsal.lida.entity.Blog;
import cz.bahsal.lida.entity.Item;
import cz.bahsal.lida.entity.Role;
import cz.bahsal.lida.entity.User;
import cz.bahsal.lida.repository.BlogRepository;
import cz.bahsal.lida.repository.ItemRepository;
import cz.bahsal.lida.repository.RoleRepository;
import cz.bahsal.lida.repository.UserRepository;

@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("0000"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		User userUser = new User();
		userUser.setEnabled(true);
		userUser.setName("üser");
		userUser.setPassword(encoder.encode("0000"));
		List<Role> roless = new ArrayList<Role>();
		roless.add(roleUser);
		userUser.setRoles(roless);
		userRepository.save(userUser);
		
		Blog blogJavavids = new Blog();
		blogJavavids.setName("JavaVids");
		blogJavavids
				.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogJavavids.setUser(userUser);
		blogRepository.save(blogJavavids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavavids);
		item1.setTitle("first");
		item1.setLink("http://www.blabla.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);

		Item item2 = new Item();
		item2.setBlog(blogJavavids);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
	}
}
