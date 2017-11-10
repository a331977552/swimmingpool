package uk.co.jsmondswimmingpool.entity.custom;


public class CommonEntity {
	
	
	
	private String msg;
	private int status;
	public CommonEntity() {
		super();
	}
	private Object bean;
	public CommonEntity(String msg, int status, Object bean) {
		super();
		this.msg = msg;
		this.status = status;
		this.bean = bean;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getBean() {
		return bean;
	}
	public void setBean(Object bean) {
		this.bean = bean;
	}
	

}
