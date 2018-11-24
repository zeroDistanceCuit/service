package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.userMapper;
import po.User;

@Service("userService")
public class UserServiceImp implements UserService{
	@Autowired
	private userMapper userMapper;
	
	//登陆校验
	@Override
	public User LoginTest(User user) throws Exception{
		return userMapper.LoginTest(user);
	}
}
