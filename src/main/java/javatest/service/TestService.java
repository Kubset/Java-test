package javatest.service;

import javatest.model.Answer;
import javatest.model.Test;
import javatest.repository.IAnswerRepository;
import javatest.repository.IQuestionRepository;
import javatest.repository.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService  {

    IQuestionRepository iQuestionRepository;
    ITestRepository iTestRepository;
    IAnswerRepository iAnswerRepository;

    @Autowired
    public TestService(IQuestionRepository iQuestionRepository, ITestRepository iTestRepository, IAnswerRepository iAnswerRepository) {
        this.iQuestionRepository = iQuestionRepository;
        this.iTestRepository = iTestRepository;
        this.iAnswerRepository = iAnswerRepository;
    }

    public Test getTestById(Long id) {
        Test test =  iTestRepository.findOne(id);

        test.getQuestions()
                .stream()
                .filter(x -> x.getCodeSnippet() != null)
                .forEach(x -> x.setCodeSnippet(convertToCodesnippet(x.getCodeSnippet())));

        return test;
    }


    private String convertToCodesnippet(String code) {
        final String uri = "http://hilite.me/api";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri)
                .queryParam("code", code)
                .queryParam("lexer", "java")
                .queryParam("lineos", "number");
        UriComponents uriComponents = builder.build().encode();
        ResponseEntity<String> responseEntity = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET,
                entity, String.class);

        return responseEntity.getBody();
    }

}
