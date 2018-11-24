package Controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import md5_token.MD5Util;
import po.ErrorResponse;
import po.UserJson;
import po.User;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/student/token", method = RequestMethod.POST)
	@ResponseBody
	public void test(@RequestBody User user, HttpServletRequest request, HttpSession session, HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		ObjectMapper objectMapper = new ObjectMapper();
		String json;
		
		User tempUser = new User();
		tempUser = userService.LoginTest(user);
		if(tempUser == null){
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setStatus(401);
			errorResponse.setTimestamp(new Date().getTime());
			errorResponse.setError("invalid_token");
			errorResponse.setMessage("身份认证令牌验证失败，请重新登录");
			errorResponse.setPath(InterfacePath.TOKEN);
			json = objectMapper.writeValueAsString(errorResponse);
			
		}else {
			//session失效为1小时
			session.setMaxInactiveInterval(60*60);		
			UserJson loginUser = new UserJson();
			loginUser.setId(tempUser.getId());
			//设置超时时间，传入session有效时常：分钟
			loginUser.setExpiredTime(60);
			//token设置
			loginUser.setToken(MD5Util.MD5(tempUser.getLogin_name()+tempUser.getPassword()+ new Date().getTime()));

			session.setAttribute("token", loginUser.getToken());
			session.setAttribute("user", tempUser);
			session.setAttribute("login", true);
			json = objectMapper.writeValueAsString(loginUser);
		}
		response.getWriter().write(json);
	}
	
}
