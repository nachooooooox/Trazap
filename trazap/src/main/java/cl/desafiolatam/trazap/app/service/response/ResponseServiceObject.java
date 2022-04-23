package cl.desafiolatam.trazap.app.service.response;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("responseServiceObject")
public class ResponseServiceObject {
	private Object body;
	private List<ResponseServiceMessage> messageList;

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public List<ResponseServiceMessage> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<ResponseServiceMessage> messageList) {
		this.messageList = messageList;
	}
	
}
