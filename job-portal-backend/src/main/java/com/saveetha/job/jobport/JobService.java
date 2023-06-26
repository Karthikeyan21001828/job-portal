package com.saveetha.job.jobport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JobService {

    private final JobRepository jobrepository;

    @Autowired
    public JobService(JobRepository jobrepository) {
        this.jobrepository = jobrepository;
    }

    public List<Job> displayJobDetails() {
        return jobrepository.findAll();
    }

    public void registerNewJob(Job job) {
        Optional<Job> jobOptional =jobrepository.findJobByjobName(job.getJobName());
        if(jobOptional.isPresent())
        {
            throw new IllegalStateException("Job already exist.");
        }
        jobrepository.save(job);
    }

    public void removeEmployee(Long jobID) {
        boolean jobExist=jobrepository.existsById(jobID);
        if(!jobExist)
        {
            throw new IllegalStateException("Job with Id "+jobID+" does'nt exist");
        }
        jobrepository.deleteById(jobID);
    }
}
