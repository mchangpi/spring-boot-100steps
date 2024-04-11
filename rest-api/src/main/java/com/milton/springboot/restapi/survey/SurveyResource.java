package com.milton.springboot.restapi.survey;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {

  private SurveyService surveyService;

  public SurveyResource(SurveyService surveyService) {
    super();
    this.surveyService = surveyService;
  }

  // /surveys => surveys
  @RequestMapping("/surveys")
  public List<Survey> retrieveAllSurveys() {
    return surveyService.retrieveAllSurveys();
  }

  // http://localhost.8080/surveys/survey1

  @RequestMapping("/surveys/{surveyId}")
  public Survey retrieveSurveyById(@PathVariable String surveyId) {
    Survey survey = surveyService.retrieveSurveyById(surveyId);
    if (survey == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return survey;
  }

  // http://localhost:8080/surveys/survey1/questions

  @RequestMapping("/surveys/{surveyId}/questions")
  public List<Question> retrieveAllSurveyQuestions(
      @PathVariable String surveyId) {
    List<Question> questions = surveyService
        .retrieveAllSurveyQuestions(surveyId);

    if (questions == null)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    return questions;
  }

  // http://localhost:8080/surveys/survey1/questions/question1

  @RequestMapping("/surveys/{surveyId}/questions/{questionId}")
  public Question retrieveSpecificSurveyQuestion(@PathVariable String surveyId,
      @PathVariable String questionId) {
    Question question = surveyService.retrieveSpecificSurveyQuestion(surveyId,
        questionId);

    if (question == null)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    return question;
  }

  /*
   * POST http://localhost:8080/surveys/survey1/questions { "id": "SOME_ID",
   * "description": "Your Favorite Cloud Platform", "options": [ "AWS", "Azure",
   * "Google Cloud", "Oracle Cloud" ], "correctAnswer": "Google Cloud" }
   */
  @RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.POST)
  public ResponseEntity<Object> addNewSurveyQuestion(
      @PathVariable String surveyId, @RequestBody Question question) {

    String questionId = surveyService.addNewSurveyQuestion(surveyId, question);

    // /surveys/{surveyId}/questions/{questionId}
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{questionId}").buildAndExpand(questionId).toUri();

    System.out.println("uri cur location: "
        + ServletUriComponentsBuilder.fromCurrentRequest().build().toUri());
    System.out.println("uri location: " + location);

    return ResponseEntity.created(location).build();
  }

  @RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", 
      method = RequestMethod.DELETE)
  public ResponseEntity<Object> deleteSurveyQuestion(
      @PathVariable String surveyId, @PathVariable String questionId) {
    surveyService.deleteSurveyQuestion(surveyId, questionId);

    return ResponseEntity.noContent().build();
  }

}
