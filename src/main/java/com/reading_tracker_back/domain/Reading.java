package com.reading_tracker_back.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "readings")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Reading {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(nullable = false)
	private LocalTime startTime;
	
	@Column(nullable = false)
	private LocalTime endTime;
	
	@Column(nullable = false)
	private int startPage;
	
	@Column(nullable = false)
	private int endPage;
	
	private String notes;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;

}
