package com.example.demo.Entity;



import javax.persistence.*;

import java.time.LocalDate;
import java.util.*;


@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private  Long id;


    private String name;

    private LocalDate date;

    private String startTime;

    private String endTime;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_conference",joinColumns = @JoinColumn(name = "conference_id"),inverseJoinColumns = @JoinColumn(name ="user_id"))
    private Set<User>users= new LinkedHashSet<>();


    public Conference() {
    }

    public Conference(String name, LocalDate date, String startTime, String endTime, Set<com.example.demo.Entity.User> users) {
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.users = users;
    }

    public Conference(String name, LocalDate date, String startTime, String endTime) {
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Set<com.example.demo.Entity.User> getUsers() {
        return users;
    }

    public void setUsers(Set<com.example.demo.Entity.User> users) {
        this.users = users;
    }
    public int Setsize(Set<User> users){
        int size = users.size();
        return size;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conference that = (Conference) o;
        return Objects.equals(id, that.id);
    }



}
