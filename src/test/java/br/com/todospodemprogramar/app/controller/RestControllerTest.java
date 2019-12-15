package br.com.todospodemprogramar.app.controller;

import br.com.todospodemprogramar.app.mock.UserData;
import br.com.todospodemprogramar.app.model.User;
import br.com.todospodemprogramar.app.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(RestController.class)
public class RestControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private UserService service;

    private User user = new User();
    private User returnedUser;

    public static final String USERNAME = "soandso";
    public static final String NAME = "so and so";
    public static final String HOBBY = "my hobbies";
    public static final String EXPERIENCE = "so-and-so";
    public static final String CONTACT = "so";
    public static final String PASSWORD = "mysecret";



    @Before
    public void setup(){

        user.setName(NAME);
        user.setUsername(USERNAME);
        user.setPassword(PASSWORD);
        user.setExperience(EXPERIENCE);
        user.setContact("so");
        user.setHobby(HOBBY);

        returnedUser = UserData.getUserMock(99999);

    }

    @Test
    public void deveSalvarUsuario() throws Exception {

        user.setId(99999);

        when(service.saveMyUser(eq(user))).thenReturn(returnedUser);

        mvc.perform(MockMvcRequestBuilders.post("/v2/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(user.equals(returnedUser),is(true));
    }

    @Test
    public void naoDeveSalvarUsuario() throws Exception {

        user.setId(00000);

        User returnedUser = UserData.getUserMock(99999);

        when(service.saveMyUser(eq(user))).thenReturn(returnedUser);

        mvc.perform(MockMvcRequestBuilders.post("/v2/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(user.equals(returnedUser),is(false));
    }

    @After
    public void tearDown(){

        user = null;

    }
}
