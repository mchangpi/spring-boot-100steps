package com.milton.learnjpa.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.milton.learnjpa.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

  @Autowired
  private CourseJdbcRepository repository;

  @Override
  public void run(String... args) throws Exception {
    repository.insert(new Course(1, "Learn AWS", "Milton"));
    repository.insert(new Course(2, "Learn Azure", "Milton"));
    repository.insert(new Course(3, "Learn GCP", "Milton"));
    
    repository.deleteById(1);
  }

}
