package com.yashh.controller;


import com.yashh.model.Subscription;
import com.yashh.repository.SubscriptionRepository;
import com.yashh.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yashh.config.JwtProvider;
import com.yashh.exception.UserException;
import com.yashh.model.User;
import com.yashh.repository.UserRepository;
import com.yashh.request.LoginRequest;
import com.yashh.response.AuthResponse;
import com.yashh.service.CustomeUserServiceImplementation;
import com.yashh.service.UserService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CustomeUserServiceImplementation customUserDetails;
	
	@Autowired
    private UserService userService;

	@Autowired
	private SubscriptionService subscriptionService;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	

	@PostMapping({"/register", "/signup"})
	public ResponseEntity<AuthResponse> createUserHandler(
			@RequestBody User user) throws UserException {
		
		System.out.println("Register endpoint called with user: " + user.getEmail());
		
		String email = user.getEmail();
		String password = user.getPassword();
		String fullName = user.getFullName();
		String role=user.getRole();

		User isEmailExist = userRepository.findByEmail(email);

		if (isEmailExist!=null) {

			throw new UserException("Email Is Already Used With Another Account");
		}

		// Create new user
		User createdUser = new User();
		createdUser.setEmail(email);
		createdUser.setFullName(fullName);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setRole(role);

		User savedUser = userRepository.save(createdUser);

		Subscription subscription = subscriptionService.createSubscription(savedUser);

//		subscriptionRepository.save(subscription);

		Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = JwtProvider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(token);
		authResponse.setMessage("Register Success");

		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);

	}

	@PostMapping({"/login", "/signin"})
	public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest) {
		
		System.out.println("Login endpoint called with email: " + loginRequest.getEmail());

		String username = loginRequest.getEmail();
		String password = loginRequest.getPassword();

		System.out.println(username + " ----- " + password);

		Authentication authentication = authenticate(username, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = JwtProvider.generateToken(authentication);
		AuthResponse authResponse = new AuthResponse();

		authResponse.setMessage("Login Success");
		authResponse.setJwt(token);

		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
	}

	private Authentication authenticate(String username, String password) {
		UserDetails userDetails = customUserDetails.loadUserByUsername(username);

		System.out.println("sign in userDetails - " + userDetails);

		if (userDetails == null) {
			System.out.println("sign in userDetails - null " + userDetails);
			throw new BadCredentialsException("Invalid username or password");
		}
		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			System.out.println("sign in userDetails - password not match " + userDetails);
			throw new BadCredentialsException("Invalid username or password");
		}
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}

	
}
