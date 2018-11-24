package po;

import java.util.Date;

//通用异常响应状态类
public class ErrorResponse {
	private int status;									//状态码
	private String message;								//状态消息
	private String path;								//请求接口
	private Long timestamp;   							//时间戳
	private String error;								//错误代码
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long time) {
		this.timestamp = time;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	
	
}
