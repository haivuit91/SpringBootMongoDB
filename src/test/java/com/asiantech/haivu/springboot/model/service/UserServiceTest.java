package com.asiantech.haivu.springboot.model.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.asiantech.haivu.springboot.Application;
import com.asiantech.haivu.springboot.model.User;
import com.asiantech.haivu.springboot.model.repository.UserRepository;
import com.asiantech.haivu.springboot.model.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserServiceTest {

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Mock
	private UserRepository userRepository;

	@Spy
	List<User> listDB = new ArrayList<User>();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(userRepository.findAll()).then(new Answer<List<User>>() {
			@Override
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				for (int i = 0; i < 10; i++) {
					users.add(new User("", "First name " + i, "Last name " + i, "Email " + i, "Password" + i));
				}
				return users;
			}
		});
		
		Mockito.when(userRepository.findByEmail(Mockito.anyString())).then(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User("", "First name", "Last name", "Email", "Password");
				return user;
			}
		});
		
		Mockito.when(userRepository.save(Mockito.any(User.class))).then(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User("", "First name", "Last name", "Email", "Password");
				return user;
			}
		});
		
		Mockito.doAnswer(new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				User user = (User) invocation.getArguments()[0];
				listDB.add(user);
				return null;
			}
		}).when(userRepository).save(Mockito.any(User.class));
	}
	
	@Test
	public void getUsers() {
		List<User> users = userServiceImpl.getUsers();
		Assert.assertEquals(users.size(), 10);
	}
	
	@Test
	public void getUserByEmail() {
		String email = "Email 1";
		User user = userServiceImpl.getUserByEmail(email);
		Assert.assertTrue(user != null);
	}
	
	@Test
	public void save() {
		userServiceImpl.save(new User("", "First name", "Last name", "Email", "Password"));
		Assert.assertEquals(listDB.size(), 1);
	}
	
	@Test
	public void delete() {
		Assert.assertTrue(userServiceImpl.delete(1));
	}

}
