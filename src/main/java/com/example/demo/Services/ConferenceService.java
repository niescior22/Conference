package com.example.demo.Services;

import com.example.demo.Entity.Conference;
import com.example.demo.Entity.User;

import java.util.List;

public interface ConferenceService {
    Conference saveConference(Conference conference);

    Conference getConference(Long id);

    List<Conference>getallConferences();

    void deleteConference(Conference conference);

    Conference updateConference(Conference conference);

    long countConference();
}
