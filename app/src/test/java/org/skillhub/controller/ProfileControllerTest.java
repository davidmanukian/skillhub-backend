package org.skillhub.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skillhub.model.Profile;
import org.skillhub.model.Skill;
import org.skillhub.service.JwtService;
import org.skillhub.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProfileController.class)
public class ProfileControllerTest {

  @MockBean
  private ProfileService profileService;

  @Autowired
  private MockMvc mockMvc;


  @Test
  public void testGetProfile() throws Exception {
    System.out.println("All handlerMappings " + mockMvc.getDispatcherServlet().getServletContext().getServerInfo());
    when(profileService.getProfile(any()))
        .thenReturn(profile());

    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(JwtService.generateToken(Map.of(), "MyUsername"));

    Authentication authentication = new UsernamePasswordAuthenticationToken(
        "MyUsername", null, Collections.singletonList(new SimpleGrantedAuthority("MANAGER")));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    mockMvc.perform(
            MockMvcRequestBuilders.get("/SkillHub/profile")
                .headers(headers))
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }

  private Profile profile() {
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Java", BigDecimal.TEN));

    Profile profile = new Profile();
    profile.setId(1111);
    profile.setFirstName("FirstName");
    profile.setLastName("LastName");
    profile.setSkills(skills);
    profile.setAbout("Big text about you");
    profile.setPosition("Senior Software Engineer");
    profile.setTeam("Dream team");
    return profile;
  }
}
