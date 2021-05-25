package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Meeting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer meetingId;
	private String schedulerName;
	private String teamName;
	private String purpose;
	private LocalDate meetingDate;
	
	public Integer getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}
	public String getSchedulerName() {
		return schedulerName;
	}
	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public LocalDate getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(LocalDate meetingDate) {
		this.meetingDate = meetingDate;
	}
	
}
