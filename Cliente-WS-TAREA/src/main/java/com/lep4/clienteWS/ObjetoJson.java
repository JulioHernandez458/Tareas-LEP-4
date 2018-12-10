package com.lep4.clienteWS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjetoJson {
	
	private int id;
	private String quote;
	
	
	
	public ObjetoJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: " + this.id + ", frase: " + this.quote;
	}
	
	
	
	

}
