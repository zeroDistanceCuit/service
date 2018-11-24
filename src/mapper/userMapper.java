package mapper;

import org.apache.ibatis.annotations.Select;

import po.User;

public interface userMapper {
	@Select("select * from users where login_name = #{login_name} and password = #{password}")
	public User LoginTest(User user);
}
