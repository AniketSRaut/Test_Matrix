package com.app.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.app.entity.Designation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto extends UserDto{
	
	@NotNull
	private Designation designation;
	
	@NotNull
	private String education;
	
	
	private Set<Long> subjectId = new HashSet<>();

}
