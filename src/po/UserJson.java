package po;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//json格式包装类，继承User类


public class UserJson {
	private String token;			//用户token
	private String expiredTime;		//session过期时间
	private int id;					//用户id
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	public String getExpiredTime() {
		return expiredTime;
	}
	public void setExpiredTime(int expire) {
		 Calendar now = Calendar.getInstance();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 now.add(Calendar.MINUTE, expire);
		 this.expiredTime = sdf.format(now.getTimeInMillis());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
}
