package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.app.entity.Gender;
import com.app.entity.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto extends BaseDto{

	
	@NotEmpty( message = "Email can't be blank...")
	@Email(message = "Invalid email format...")
	private String email;	
	
	@NotEmpty(message = "Password can't be empty...")
	@Length(min = 8, max = 25, message = "Password length must be 8 to 25 characters...")
	private String password;
		
	@NotEmpty(message = "Name can't be empty...")
	private String name;
	
	
	@Size(max=10,min=10,message="enter 10 digit mobile number")
	@Pattern(regexp = "^[0-9]{10}$",message = "enter 10 digit mobile number") 
	private String phone;
	
	@NotNull
	private Gender gender;
	
	@NotEmpty(message = "Address can't be empty...")
	@Length(max = 250 )
	private String address;
	
	@NotNull
	private LocalDate dob;
	
	@NotNull
	private Role role;

	public UserDto(Long id, LocalDateTime createdTime, LocalDateTime updatedTime, boolean isDeleted,
			@NotEmpty(message = "Email can't be blank...") @Email(message = "Invalid email format...") String email,
			@NotEmpty(message = "Password can't be empty...") @Length(min = 8, max = 25, message = "Password length must be 8 to 25 characters...") String password,
			@NotEmpty(message = "Name can't be empty...") String name,
			@Size(max = 10, min = 10, message = "enter 10 digit mobile number") @Pattern(regexp = "^[0-9]{10}$", message = "enter 10 digit mobile number") String phone,
			@NotNull Gender gender, @NotEmpty(message = "Address can't be empty...") @Length(max = 250) String address,
			@NotNull LocalDate dob, @NotNull Role role) {
		super(id, createdTime, updatedTime, isDeleted);
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.dob = dob;
		this.role = role;
	}
	
	
	
}
