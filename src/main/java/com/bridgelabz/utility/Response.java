package com.bridgelabz.utility;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Response {
	
	private String responseStatus;
	private int responseCode;
	private Object responseData; 
	

}
