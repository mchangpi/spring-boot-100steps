package com.milton.springboot.restapi.survey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Survey {

  public Survey() {
    // new Survey("-1", "", "", new ArrayList<Question>());
    new Survey("-1", "", "", Collections.<Question>emptyList());
  }

  public Survey(String id, String title, String description,
      List<Question> questions) {
    super();
    this.id = id;
    this.title = title;
    this.description = description;
    this.questions = questions;
  }

  private String id;
  private String title;
  private String description;
  private List<Question> questions;

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  @Override
  public String toString() {
    return "Survey [id=" + id + ", title=" + title + ", description="
        + description + ", questions=" + questions + "]";
  }

}
