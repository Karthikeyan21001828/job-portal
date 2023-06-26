package com.saveetha.job.jobport;

import jakarta.persistence.*;

@Entity
@Table
public class Job {
    @Id
    @SequenceGenerator(
            name = "job_sequence",
            sequenceName = "job_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "job_sequence"
    )

    private Long jobID;
    private String jobName;
    private String companyName;
    private Integer salary;

    public Job() {
    }

    public Job(Long jobID, String jobName, String companyName, Integer salary) {
        this.jobID = jobID;
        this.jobName = jobName;
        this.companyName = companyName;
        this.salary = salary;
    }

    public Long getJobID() {
        return jobID;
    }

    public void setJobID(Long jobID) {
        this.jobID = jobID;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobID=" + jobID +
                ", jobName='" + jobName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
