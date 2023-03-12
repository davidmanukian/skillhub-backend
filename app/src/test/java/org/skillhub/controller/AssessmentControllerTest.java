package org.skillhub.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skillhub.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AssessmentController.class)
public class AssessmentControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGetAssessmentsToReview() throws Exception {
    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(JwtService.generateToken(Map.of(), "MyUsername"));

    Authentication authentication = new UsernamePasswordAuthenticationToken(
        "MyUsername", null, Collections.singletonList(new SimpleGrantedAuthority("MANAGER")));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    mockMvc.perform(
            MockMvcRequestBuilders.get("/SkillHub/assessment")
                .headers(headers))
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }
}
