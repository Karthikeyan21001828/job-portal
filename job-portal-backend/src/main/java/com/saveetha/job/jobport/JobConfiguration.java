package com.saveetha.job.jobport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class JobConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(JobRepository jobRepository) {
        return args -> {
            Job job1 = new Job(
                    1L,
                    "Front End Developer",
                    "ABC Company",
                    60000
            );

            Job job2 = new Job(
                    2L,
                    "Back End Developer",
                    "ABC Company",
                    65000
            );

            jobRepository.saveAll(List.of(job1, job2));
        };
    }

    @Configuration
    public class CORSConfiguration implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:3000")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*");
        }
    }
}
