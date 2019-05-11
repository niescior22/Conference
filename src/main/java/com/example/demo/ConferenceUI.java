package com.example.demo;

import com.example.demo.Entity.Conference;
import com.example.demo.Entity.User;
import com.example.demo.Services.ConferenceService;
import com.example.demo.Services.UserService;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;



@SpringUI
public class ConferenceUI  extends UI {

    @Autowired
    UserService userService;

    @Autowired
    ConferenceService conferenceService;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
       VerticalLayout mainLayout = new VerticalLayout();
        Label conference = new Label("Conference");

        mainLayout.addComponentsAndExpand(conference);
        setContent(mainLayout);
        FormLayout formLayout= new FormLayout();

        TextField textFieldLogin= new TextField("Login");
        textFieldLogin.setRequiredIndicatorVisible(true);
        textFieldLogin.setIcon(VaadinIcons.USER);
        textFieldLogin.setMaxLength(20);

        TextField textFieldEmail= new TextField("Email");
        textFieldEmail.setRequiredIndicatorVisible(true);
        textFieldEmail.setIcon(VaadinIcons.MAILBOX);
        textFieldEmail.setMaxLength(50);

        Button btnSubmit= new Button("Save");
        formLayout.setWidth(null);
        formLayout.addComponent(textFieldLogin);
        formLayout.addComponent(textFieldEmail);
        formLayout.addComponent(btnSubmit);
        mainLayout.addComponent(formLayout);

        btnSubmit.addClickListener(click-> {
                    User user = userService.saveUser(
                            new User(textFieldLogin.getValue(), textFieldEmail.getValue()));
                    Notification.show("User saved with ID:" + user.getId());
                    textFieldEmail.clear();
                    textFieldLogin.clear();
                    textFieldEmail.setVisible(false);
                    textFieldLogin.setVisible(false);
                    btnSubmit.setVisible(false);
                    mainLayout.addComponentAsFirst(new Label("Welcome fell free to sing up to as many prelessons as you want, unless they collide in time"));

        });

        Grid<Conference> grid = new Grid<>();

        grid.addColumn(Conference::getName)
                .setCaption("Conference");
        grid.addColumn(Conference::getDate)
                .setCaption("Date");
        grid.addColumn(Conference::getStartTime)
                .setCaption("Start");
        grid.addColumn(Conference::getEndTime)
                .setCaption("End");
        grid.addColumn(Conference::getUsers)
                .setCaption("size");

        grid.setItems(conferenceService.getallConferences());
        mainLayout.addComponent(grid);



       }

    }









