package com.example.demo.bootstrap;

import com.example.demo.Entity.Conference;
import com.example.demo.Entity.User;
import com.example.demo.Services.ConferenceService;
import com.example.demo.Services.UserService;
import com.example.demo.repositories.ConferenceRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

     private UserRepository userRepository;
     private ConferenceRepository conferenceRepository;

    public DevBootstrap(UserRepository userRepository, ConferenceRepository conferenceRepository) {
        this.userRepository = userRepository;
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();

    }

    private void initData() {

        Conference dockerConference= new Conference("Docker", LocalDate.of(2019,06,01),"10:00","11:45");
        Conference cloudConference = new Conference("Cloud",LocalDate.of(2019,06,01),"10:00","11:45");
        Conference amazonWebServicesConference = new Conference("amazonWebServices",LocalDate.of(2019,06,01),"10:00","11:45");
        Conference hrITConference= new Conference("HrIT", LocalDate.of(2019,06,01),"12:00","13:45");
        Conference vaadinConference = new Conference("vaadin",LocalDate.of(2019,06,01),"12:00","13:45");
        Conference cleanCodeConference = new Conference("CleanCode",LocalDate.of(2019,06,01),"12:00","13:45");

        Conference java11Conference= new Conference("java11", LocalDate.of(2019,06,02),"10:00","11:45");
        Conference swaggerConference = new Conference("Swagger",LocalDate.of(2019,06,02),"10:00","11:45");
        Conference javaEEConference= new Conference("javaEE", LocalDate.of(2019,06,02),"10:00","11:45");
        Conference webFluxConference = new Conference("webFlux",LocalDate.of(2019,06,02),"12:00","13:45");
        Conference thymeleafConference = new Conference("thymeleaf",LocalDate.of(2019,06,02),"12:00","13:45");
        Conference howToNotGetAJobConference = new Conference("howToNotGetAJob",LocalDate.of(2019,06,02),"12:00","13:45");


        User user = new User("kamil","kamil@gmail.com");

        user.getConferences().add(java11Conference);
        java11Conference.getUsers().add(user);
        user.getConferences().add(java11Conference);
        userRepository.save(user);
        conferenceRepository.save(dockerConference);
        conferenceRepository.save(cloudConference);
        conferenceRepository.save(amazonWebServicesConference);
        conferenceRepository.save(hrITConference);
        conferenceRepository.save(vaadinConference);
        conferenceRepository.save(cleanCodeConference);
        conferenceRepository.save(java11Conference);
        conferenceRepository.save(swaggerConference);
        conferenceRepository.save(javaEEConference);
        conferenceRepository.save(webFluxConference);
        conferenceRepository.save(thymeleafConference);
        conferenceRepository.save(howToNotGetAJobConference);

    }
}
