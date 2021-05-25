package com.example.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.demo.entity.Meeting;

public class MeetingDTO {
	
	private Integer meetingId;
	
	@Pattern(regexp="^[A-Za-z]+( [A-Za-z]+)*$", message="{meeting.schedulername.invalid}")
	@NotNull(message="{meeting.schedulername.notpresent}")
	private String schedulerName;
	
	@NotNull(message="{meeting.teamname.notpresent}")
	private String teamName;
	
	@NotNull(message="{meeting.purpose.notpresent}")
	private String purpose;
	
	@NotNull(message="{meeting.meetingdate.notpresent}")
	@FutureOrPresent(message="{meeting.meetingdate.invalid}")
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
	
	public static Meeting prepareEntity(MeetingDTO meetingDTO) {
		Meeting entity = new Meeting();
		entity.setMeetingId(meetingDTO.getMeetingId());
		entity.setMeetingDate(meetingDTO.getMeetingDate());
		entity.setPurpose(meetingDTO.getPurpose());
		entity.setSchedulerName(meetingDTO.getSchedulerName());
		entity.setTeamName(meetingDTO.getTeamName());
		return entity;
	}
	
	public static MeetingDTO prepareDTO(Meeting meeting) {
		MeetingDTO dto = new MeetingDTO();
		dto.setMeetingDate(meeting.getMeetingDate());
		dto.setMeetingId(meeting.getMeetingId());
		dto.setPurpose(meeting.getPurpose());
		dto.setSchedulerName(meeting.getSchedulerName());
		dto.setTeamName(meeting.getTeamName());
		return dto;
	}
}
