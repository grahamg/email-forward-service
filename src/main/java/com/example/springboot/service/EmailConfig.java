package com.example.springboot.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("email")
public class EmailConfig {
     
  private String   username;
     
    private String  pwd;
     
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
		
	@Override
	public String toString() {
		return "EmailConfig [username=" + username + ", pwd=" + pwd + "]";
	}
	
}
