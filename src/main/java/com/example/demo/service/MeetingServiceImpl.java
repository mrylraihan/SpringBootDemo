package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MeetingDTO;
import com.example.demo.entity.Meeting;
import com.example.demo.exception.MeetingSchedulerException;
import com.example.demo.repository.MeetingRepository;
import com.example.demo.validator.MeetingValidator;

@Service(value = "meetingService")
@Transactional
public class MeetingServiceImpl implements MeetingService{

	@Autowired
	private MeetingRepository meetingRepository;
	
	@Override
	public List<MeetingDTO> getAllMeetingsOfScheduler(String schedulerName) throws MeetingSchedulerException {
		List<Meeting> meetings = meetingRepository.findBySchedulerName(schedulerName);
		
		if(meetings.isEmpty()) {
			throw new MeetingSchedulerException("MeetingService.NO_MEETINGS_FOUND");
		}
	
		meetings.sort((a,b)-> a.getMeetingDate().compareTo(b.getMeetingDate()));
		List<MeetingDTO> dtos = new ArrayList<MeetingDTO>();
		
		// loop through meetings, meetings is of Meeting type
		for(Meeting m: meetings) {
			// convert Meeting(Entity) to MeetingDTO(DTO)
			MeetingDTO d = MeetingDTO.prepareDTO(m);
			// add converted DTO to list created
			dtos.add(d);
		}
		return dtos;
	}

	@Override
	public MeetingDTO scheduleMeeting(MeetingDTO meetingDTO) throws MeetingSchedulerException {
		MeetingValidator.validateMeeting(meetingDTO);
		List<Meeting> schList = meetingRepository.findBySchedulerNameAndMeetingDate(meetingDTO.getSchedulerName(), meetingDTO.getMeetingDate());
		
		if(!schList.isEmpty()) {
			throw new MeetingSchedulerException("MeetingService.MEETING_DATE_UNAVAILABLE");
		}
		
		List<Meeting> teamList = meetingRepository.findByTeamNameAndMeetingDate(meetingDTO.getTeamName(), meetingDTO.getMeetingDate());
		if(!teamList.isEmpty()) {
			throw new MeetingSchedulerException("MeetingService.TEAM_UNVAILABLE");
		}
		
		Meeting meeting = MeetingDTO.prepareEntity(meetingDTO);
		meeting = meetingRepository.save(meeting);
		meetingDTO.setMeetingId(meeting.getMeetingId());
		
		return meetingDTO;
	}

}
