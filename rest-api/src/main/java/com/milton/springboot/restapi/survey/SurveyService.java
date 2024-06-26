package com.milton.springboot.restapi.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {

  private static List<Survey> surveys = new ArrayList<>();

  static {

    Question question1 = new Question("Question1",
        "Most Popular Cloud Platform Today",
        Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
    Question question2 = new Question("Question2",
        "Fastest Growing Cloud Platform",
        Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"),
        "Google Cloud");
    Question question3 = new Question("Question3", "Most Popular DevOps Tool",
        Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"),
        "Kubernetes");

    List<Question> questions = new ArrayList<>(
        Arrays.asList(question1, question2, question3));

    Survey survey = new Survey("Survey1", "My Favorite Survey",
        "Description of the Survey", questions);

    surveys.add(survey);

  }

  public List<Survey> retrieveAllSurveys() {
    return surveys;
  }

  public Survey retrieveSurveyById(String surveyId) {

    Predicate<? super Survey> predicate = s -> s.getId()
        .equalsIgnoreCase(surveyId);

    Survey survey = surveys.stream().filter(predicate).findFirst()
        .orElseGet(() -> new Survey());

    /*
     * surveys.stream().forEach(s -> { System.out.println("surveyId: " +
     * s.getId()); System.out.println("equals: " +
     * s.getId().equalsIgnoreCase(surveyId)); }); System.out.println("survey8: "
     * + survey.toString());
     */
    return survey;
  }

  public List<Question> retrieveAllSurveyQuestions(String surveyId) {
    Survey survey = retrieveSurveyById(surveyId);

    if (survey == null) {
      // return null;
      return Collections.<Question>emptyList();
    }

    return survey.getQuestions();
  }

  public Question retrieveSpecificSurveyQuestion(String surveyId,
      String questionId) {

    List<Question> surveyQuestions = retrieveAllSurveyQuestions(surveyId);

    if (surveyQuestions == null) {
      return new Question();
    }

    Optional<Question> optionalQuestion = surveyQuestions.stream()
        .filter(q -> q.getId().equalsIgnoreCase(questionId)).findFirst();

    if (optionalQuestion.isEmpty()) {
      return new Question();
    }

    return optionalQuestion.orElseGet(() -> new Question());
  }

  public String addNewSurveyQuestion(String surveyId, Question question) {
    List<Question> questions = retrieveAllSurveyQuestions(surveyId);
    question.setId(generateRandomId());
    questions.add(question);
    return question.getId();
  }

  private String generateRandomId() {
    SecureRandom secureRandom = new SecureRandom();
    String randomId = new BigInteger(32, secureRandom).toString();
    return randomId;
  }

  public String deleteSurveyQuestion(String surveyId, String questionId) {
    List<Question> surveyQuestions = retrieveAllSurveyQuestions(surveyId);

    if (surveyQuestions == null)
      return "-1";

    Predicate<? super Question> predicate = q -> q.getId()
        .equalsIgnoreCase(questionId);
    boolean removed = surveyQuestions.removeIf(predicate);

    if (!removed)
      return "-1";

    return questionId;
  }

  public void updateSurveyQuestion(String surveyId, String questionId,
      Question updateQuestion) {
    List<Question> questions = retrieveAllSurveyQuestions(surveyId);

    for (int i = 0; i < questions.size(); i++) {
      if (questions.get(i).getId().equalsIgnoreCase(updateQuestion.getId())) {
        questions.set(i, updateQuestion);
        System.out.println("found: " + questions.get(i).getId());
        break;
      }
    }
    /*
     * questions.removeIf(q -> q.getId().equalsIgnoreCase(questionId));
     * questions.add(question);
     */
  }

}
