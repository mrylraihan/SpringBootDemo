package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MeetingDTO;
import com.example.demo.exception.MeetingSchedulerException;

public interface MeetingService {
	List<MeetingDTO> getAllMeetingsOfScheduler(String schedulerName) throws MeetingSchedulerException;
	MeetingDTO scheduleMeeting(MeetingDTO meetingDTO) throws MeetingSchedulerException;
}