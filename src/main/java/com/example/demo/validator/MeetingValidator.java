package com.example.demo.validator;

import java.time.DayOfWeek;
import java.time.LocalDate;

import com.example.demo.dto.MeetingDTO;
import com.example.demo.exception.MeetingSchedulerException;

public class MeetingValidator {
	
	private MeetingValidator() {
		
	}
	
	public static void validateMeeting(MeetingDTO meetingDTO) throws MeetingSchedulerException {
		if(!isValidTeamName(meetingDTO.getTeamName())) {
			throw new MeetingSchedulerException("MeetingValidator.INVALID_TEAM_NAME");
		}
		
		if(!isValidMeetingDate(meetingDTO.getMeetingDate())) {
			throw new MeetingSchedulerException("MeetingValidator.INVALID_MEETING_DATE");
		}
	}
	
	public static Boolean isValidTeamName(String teamName) {
		if(teamName.equals("ETAMYSJAVA") || teamName.equals("ETAMYSUI") || teamName.equals("ETAMYSBI")
				|| teamName.equals("ETAMYSMS") || teamName.equals("ETAMYSAI")) {
			return true;
		}
		
		return false;
	}
	
	public static Boolean isValidMeetingDate(LocalDate meetingDate) {
		if(meetingDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
				meetingDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			return false;
		}
		
		return true;
	}
}
