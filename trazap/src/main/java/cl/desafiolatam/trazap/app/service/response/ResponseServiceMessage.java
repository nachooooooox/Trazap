package cl.desafiolatam.trazap.app.service.response;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("responseServiceMessage")
public class ResponseServiceMessage {
	private Date timestamp;
	private String code;
	private ResponseServiceMessageType type;
	private String message;
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public ResponseServiceMessageType getType() {
		return type;
	}
	public void setType(ResponseServiceMessageType type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
