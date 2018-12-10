package com.lep4.clienteWS;

public class JsonRoot {
	
	private String type;
	private ObjetoJson value;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ObjetoJson getValue() {
		return value;
	}
	public void setValue(ObjetoJson value) {
		this.value = value;
	}
	public JsonRoot() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JsonRoot [type=" + type + ", value=" + value + "]";
	}
	
	

}
