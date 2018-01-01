package com.pratik.dbservice.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quotes {

	@JsonProperty(value="username")
	private String userName;
	private List<String> quotes;
	
	public Quotes() {
	}
	
	public Quotes(String userName, List<String> quotes) {
		super();
		this.userName = userName;
		this.quotes = quotes;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<String> getQuotes() {
		return quotes;
	}
	
	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
}
