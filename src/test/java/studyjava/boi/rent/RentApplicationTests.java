package studyjava.boi.rent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import studyjava.boi.rent.entity.Role;
import studyjava.boi.rent.entity.User;
import studyjava.boi.rent.repository.ApartmentRepository;
import studyjava.boi.rent.repository.RoleRepository;
import studyjava.boi.rent.repository.UserRepository;
import studyjava.boi.rent.service.ApartmentService;
import studyjava.boi.rent.service.UserService;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static studyjava.boi.rent.config.SpringSecurity.passwordEncoder;

@SpringBootTest
class RentApplicationTests {
    @Autowired
    ApartmentRepository apartmentRepository;

    @Autowired
    ApartmentService apartmentService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;


    final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(8);

    @Test
    void contextLoads() {
    }

    @Test
    void del() {
        apartmentRepository.deleteById(4L);
    }

    @Test
    void insertUsersRolesTest(){
		//============= add roles if its not on db
		Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        if (adminRole==null) {
            adminRole = new Role();
            adminRole.setId(0L);
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }
        Role userRole = roleRepository.findByName("ROLE_USER");
        if (userRole==null) {
            userRole = new Role();
            userRole.setId(0L);
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }
		assertEquals(2,roleRepository.findAll().size());

        //Add admin and user
		Set<Role> rolesSetAdmin = new LinkedHashSet<>();
		rolesSetAdmin.add(adminRole);
		Set<Role> rolesSetUser = new LinkedHashSet<>();
		rolesSetUser.add(userRole);

		User user1 = null;
		String passwordAdmin = passwordEncoder().encode("admin");
		System.out.println(passwordAdmin);
        user1 = userRepository.findByEmail("admin@gmail.com");
		if (user1==null) {
			user1 = new User(0L,"Dmytro Dvukhhlavov","admin@gmail.com",passwordAdmin,rolesSetAdmin);
			userRepository.save(user1);
		}

		User user2 = null;
		String passwordUser = passwordEncoder().encode("12345");
		System.out.println(passwordUser);
		user2 = userRepository.findByEmail("user@gmail.com");
		if (user2==null) {
			user2 = new User(0L,"User Simple","user@gmail.com",passwordUser,rolesSetUser);
			userRepository.save(user2);
		}

		assertEquals(2,userRepository.findAll().size());
		user1 = userRepository.findByEmail("admin@gmail.com");
		assertEquals(user1.getRoles().size(),1);
		user2 = userRepository.findByEmail("user@gmail.com");
		assertEquals(user2.getRoles().size(),1);
    }
}
