package com.codewithrajeev.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min=4,message = "Username must be min of 4 charcaters!!")
	private String name;
	
	@Email(message = "Please enter valid email address")
	private String email;
	
	@NotEmpty
	@Size(min=3, message = "Password must be min of 3 chars and maximum of 4 chars")
	private String password;
	
	@NotEmpty
	private String about;

}
