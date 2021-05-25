package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meeting;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Integer> {
	List<Meeting> findBySchedulerName(String schedulerName);
	List<Meeting> findBySchedulerNameAndMeetingDate(String schedulerName, LocalDate meetingDate);
	List<Meeting> findByTeamNameAndMeetingDate(String teamName, LocalDate meetingDate);
}


// trees are like linked list 

