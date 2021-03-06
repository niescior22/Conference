package com.example.demo.Services;

import com.example.demo.Entity.Conference;
import com.example.demo.Entity.User;
import com.example.demo.Services.ConferenceService;
import com.example.demo.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ConferenceServiceImp implements ConferenceService {
    @Autowired
    ConferenceRepository conferenceRepository;

    @Override
    public Conference saveConference(Conference conference) {
        conference = conferenceRepository.save(conference);
        return conference;

    }

    @Override
    public Conference getConference(Long id) {
        return conferenceRepository.getOne(id);
    }

    @Override
    public List<Conference> getallConferences() {
        return conferenceRepository.findAll();
    }

    @Override
    public void deleteConference(Conference conference) {
       conferenceRepository.delete(conference);
    }

    @Override
    public Conference updateConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    @Override
    public long countConference() {
        return conferenceRepository.count();
    }

    @Override
    public void addUserToConference(User user, Conference clickedConference) {
        clickedConference.getUsers().add(user);
        updateConference(clickedConference);
    }
     @Transactional
    @Override
    public void removeUserToConference(User user, Conference clickedConference) {
        clickedConference.getUsers().remove(user);
        updateConference(clickedConference);

    }
}
