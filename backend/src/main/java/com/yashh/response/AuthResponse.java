package com.yashh.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	
	private String jwt;
	private boolean status;
	private String message;
	
	// Explicit getters and setters in case Lombok is not working properly
	public String getJwt() {
		return jwt;
	}
	
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
