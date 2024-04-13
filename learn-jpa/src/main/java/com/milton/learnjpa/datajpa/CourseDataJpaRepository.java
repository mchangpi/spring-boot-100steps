package com.milton.learnjpa.datajpa;

import com.milton.learnjpa.course.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDataJpaRepository extends JpaRepository<Course, Long> {

}
