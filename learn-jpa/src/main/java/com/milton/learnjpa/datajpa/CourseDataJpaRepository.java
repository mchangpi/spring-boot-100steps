package com.milton.learnjpa.datajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milton.learnjpa.course.Course;

public interface CourseDataJpaRepository extends JpaRepository<Course, Long> {

  List<Course> findByAuthor(String author);
}
