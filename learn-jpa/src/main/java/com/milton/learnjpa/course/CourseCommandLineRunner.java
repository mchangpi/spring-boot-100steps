package com.milton.learnjpa.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.milton.learnjpa.datajpa.CourseDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

  @Autowired
  private CourseDataJpaRepository repository;

  @Override
  public void run(String... args) throws Exception {
    repository.save(new Course(1, "Learn AWS", "Milton"));
    repository.save(new Course(2, "Learn Azure", "Milton"));
    repository.save(new Course(3, "Learn GCP", "Milton"));
    
    repository.deleteById(1l);
    
    System.out.println(repository.findById(2l));
    System.out.println(repository.findById(3l));
  }

  /*
  @Autowired
  private CourseJdbcRepository repository;
  
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
  */
}
