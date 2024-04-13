package com.milton.learnjpa.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.milton.learnjpa.course.jpa.CourseJpaRepository;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

  @Autowired
  private CourseJpaRepository repository;

  @Override
  public void run(String... args) throws Exception {
    repository.insert(new Course(1, "Learn AWS", "Milton"));
    repository.insert(new Course(2, "Learn Azure", "Milton"));
    repository.insert(new Course(3, "Learn GCP", "Milton"));
    
    repository.deleteById(1);
    
    System.out.println(repository.findById(2));
    System.out.println(repository.findById(3));
  }

}
