package com.bennettebrahim.Freelance.System.controller;

import com.bennettebrahim.Freelance.System.model.Job;
import com.bennettebrahim.Freelance.System.repository.ClientRepository;
import com.bennettebrahim.Freelance.System.repository.JobRepository;
import com.bennettebrahim.Freelance.System.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @CrossOrigin // This allows your HTML page to talk to your API
    @RestController // Tells Spring this class handles HTTP requests
    @RequestMapping("/api/jobs") // The URL path
    public class JobController {

        @Autowired // This automatically connects the repository
        private JobRepository jobRepository;

        @Autowired
        private ClientRepository clientRepository;

        // 1. GET all jobs (To see the list)
        @GetMapping
        public List<Job> getAllJobs() {
            return jobRepository.findAll();
        }

        // 2. POST a new job (To add to database)
        @PostMapping
        public Job createJob(@RequestBody Job job) {
            return jobService.saveJob(job);
        }

        // 3. GET a single job by ID
        @GetMapping("/{id}")
        public ResponseEntity<Job> getJobById(@PathVariable Long id) {
            return jobRepository.findById(id)
                    .map(job -> ResponseEntity.ok().body(job)) // If found, return 200 OK + Job
                    .orElse(ResponseEntity.notFound().build()); // If not found, return 404
        }

        // 4. DELETE a job
        @DeleteMapping("/{id}")
        public String deleteJobById(@PathVariable Long id) {
            jobRepository.deleteById(id);
            return "Job with id " + id + " was deleted";
        }


        @Autowired
        private JobService jobService;

        @PostMapping("/with-client/{clientId}")
        public ResponseEntity<Job> createJobForClient(
                @PathVariable Long clientId,
                @RequestBody Job job) {

            return jobService.saveJobToClient(clientId, job)
                    .map(savedJob -> ResponseEntity.ok(savedJob))
                    .orElse(ResponseEntity.notFound().build());
        }



    }
