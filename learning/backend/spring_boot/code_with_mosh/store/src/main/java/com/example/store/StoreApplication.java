package com.example.store;

import com.example.store.entities.*;
import com.example.store.repository.ProfileRepository;
import com.example.store.repository.UserRepository;
import com.example.store.services.AddressService;
import com.example.store.services.ProductService;
import com.example.store.services.ProfileService;
import com.example.store.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class StoreApplication {
	static ApplicationContext context;   

	@Transactional
	public static void main(String[] args) {
		context = SpringApplication.run(StoreApplication.class, args);
//		UserRepository userRepository = context.getBean(UserRepository.class);
//		ProfileRepository profileRepository = context.getBean(ProfileRepository.class);
//		ProfileService profileService = context.getBean(ProfileService.class);
		UserService userService = context.getBean(UserService.class);

//		profileService.getProfiles();
//		userService.fetchProductWithExampleObject();

//		userService.fetchProductsByCriteria();

//		userService.fetchProductsBySpecifications("prod", null, null);
//		userService.fetchSortedProducts();
		userService.fetchPaginatedProducts(0, 10);

	}

	public static void addUser(int id) {
		User user = User.builder()
				.name("user " + id)
				.password("password")
				.email("user" + id + "@gmail.com")
				.build();

		UserService userService = context.getBean(UserService.class);
		userService.addUser(user);
	}



	public void temp() {
		ProductService productService = context.getBean(ProductService.class);
		UserService userService = context.getBean(UserService.class);

		User user = User.builder()
				.name("user 1")
				.password("password")
				.email("user1@gmail.com")
				.build();

//		userService.addUser(user);

		Category category = Category.builder()
				.name("category 4")
				.build();

		Product product = Product.builder()
				.name("product 5")
				.price(30)
				.description("description")
				.category(category)
				.build();

//		productService.addProduct(product);

//		userService.addWishlist();
//		productService.removeProduct(3);
//		userService.fetchProducts();

//		userService.fetchUser();
		userService.fetchProductsUsingStoredProcedure();


	}
}

