package com.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Quiz extends BaseEntity{
	
private String title;
	
	private int quizTime;
	
	private LocalDate quizScheduleDate;
	
	private LocalTime quizScheduleTime;	
	
	@Column(length = 1)
	private int status = 0; 
	
	private int quizMarks;
	
	private int passingMarks;
	
	@ManyToOne
	private Subject subject;
	
	@ManyToMany
	private Set<Batch> batch = new HashSet<Batch>();
	
	public void addBatch(Batch b) {
		batch.add(b);
	}
	public void removeBatch(Batch b) {
		batch.remove(b);
	}
	
	
	
	
	
}
