package com.milton.learnjpa.course.jpa;

import org.springframework.stereotype.Repository;

import com.milton.learnjpa.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  public void insert(Course course) {
    entityManager.merge(course);
  }
  
  public Course findById(long id) {
    return entityManager.find(Course.class, id);
  }
  
  public void deleteById(long id) {
    Course course = findById(id);
    entityManager.remove(course);
  }
}
