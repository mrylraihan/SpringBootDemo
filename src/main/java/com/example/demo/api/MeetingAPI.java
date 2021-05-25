package com.example.demo.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MeetingDTO;
import com.example.demo.exception.MeetingSchedulerException;
import com.example.demo.service.MeetingService;

@RestController
@RequestMapping(value="api")
@Validated
public class MeetingAPI {
	
	@Autowired
	private MeetingService meetingService;
	
	@GetMapping(value="meetings/{schedulerName}")
	public ResponseEntity<List<MeetingDTO>> getAllMeetingsOfScheduler
	
	(@PathVariable @Pattern(regexp = "^[A-Za-z]+( [A-Za-z]+)*$", message="{meeting.schedulername.invalid}") String schedulerName )
	
			throws MeetingSchedulerException {
		
		List<MeetingDTO> mL = meetingService.getAllMeetingsOfScheduler(schedulerName);
		
		return new ResponseEntity<List<MeetingDTO>>(mL, HttpStatus.OK);
	}
	
	@PostMapping(value="meeting")
	public ResponseEntity<MeetingDTO> scheduleMeeting(@RequestBody @Valid MeetingDTO meetingDTO) throws MeetingSchedulerException {
		
		meetingDTO = meetingService.scheduleMeeting(meetingDTO);
		
		return new ResponseEntity<MeetingDTO>(meetingDTO, HttpStatus.CREATED);
	}
}
