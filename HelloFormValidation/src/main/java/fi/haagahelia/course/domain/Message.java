package fi.haagahelia.course.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Message {
	@NotNull
	private long id;
	
    @Size(min=5, max=30)
	private String msg;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "Message [msg=" + msg + "]";
	}
}
