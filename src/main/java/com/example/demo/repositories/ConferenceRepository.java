package com.example.demo.repositories;

import com.example.demo.Entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ConferenceRepository extends JpaRepository<Conference,Long> {



}
