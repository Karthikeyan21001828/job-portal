package com.saveetha.job.jobport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
    @Query("select j from Job j where j.jobName=?1")
    Optional<Job> findJobByjobName(String jobName);
}
