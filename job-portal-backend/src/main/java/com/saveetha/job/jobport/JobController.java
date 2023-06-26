package com.saveetha.job.jobport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/job")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/")
    public List<Job> getJobDetails()
    {
        return jobService.displayJobDetails();
    }

    @PostMapping("/")
    public void postJob(@RequestBody Job job){
        jobService.registerNewJob(job);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteJob(@PathVariable("id") Long jobID)
    {
        jobService.removeEmployee(jobID);
    }
}
