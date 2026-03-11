package com.bennettebrahim.Freelance.System.repository;

import com.bennettebrahim.Freelance.System.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository extends JpaRepository<Job,Long> {

}
