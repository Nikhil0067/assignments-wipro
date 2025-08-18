package com.example.assessmentservice.entity;

import jakarta.persistence.*;

@Entity
public class Assessment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private int maxMarks;

    private boolean submitted;

    private int obtainedMarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

	public int getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	@Override
	public String toString() {
		return "Assessment [id=" + id + ", title=" + title + ", description=" + description + ", maxMarks=" + maxMarks
				+ ", submitted=" + submitted + ", obtainedMarks=" + obtainedMarks + "]";
	}

    // getters and setters
    
}
