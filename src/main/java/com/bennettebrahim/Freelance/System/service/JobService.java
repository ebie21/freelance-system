package com.bennettebrahim.Freelance.System.service;

import com.bennettebrahim.Freelance.System.model.Job;
import com.bennettebrahim.Freelance.System.repository.ClientRepository;
import com.bennettebrahim.Freelance.System.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job saveJob(Job job) {
        if (job.getPay() < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pay negative");
        }
        return jobRepository.save(job);
    }

    public Optional<Job> saveJobToClient(Long client_id, Job job) {
        return clientRepository.findById(client_id)
                .map(client -> {
                    job.setClient(client);
                    return saveJob(job);
                });

    }


}
