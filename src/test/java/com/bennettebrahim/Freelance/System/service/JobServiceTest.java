package com.bennettebrahim.Freelance.System.service;

import com.bennettebrahim.Freelance.System.model.Job;
import com.bennettebrahim.Freelance.System.repository.JobRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class JobServiceTest {

    @Mock
    private JobRepository jobRepository;
    @InjectMocks
    private JobService jobService;

    @Test
    void shouldThrowExceptionWhenPayIsNegative(){
        //Arrange
        Job job = new Job();
        job.setPay(-500.0);

        // Act & Assert
        // This line checks: "Does this method throw a ResponseStatusException?"
        assertThrows(ResponseStatusException.class, () -> jobService.saveJob(job));
    }

    @Test
    void shouldCallRepositoryWhenPayIsPositive(){
        Job job = new Job();
        job.setPay(500.0);

        when(jobRepository.save(job)).thenReturn(job);

        jobService.saveJob(job);

        verify(jobRepository, times(1)).save(job);

    }

}