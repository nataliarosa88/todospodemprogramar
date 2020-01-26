package br.com.todospodemprogramar.app.controller;

import br.com.todospodemprogramar.app.exception.DuplicatedKeyException;
import br.com.todospodemprogramar.app.exception.EntityNotFoundException;
import br.com.todospodemprogramar.app.mock.UserData;
import br.com.todospodemprogramar.app.model.User;
import br.com.todospodemprogramar.app.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    private static final String URL_TEMPLATE = "/v2/users/";
    @Autowired
    MockMvc mvc;

    @MockBean
    private UserService service;

    @Test
    public void insertUser() throws Exception {
        int userId = 99999;
        User user = UserData.getUserMock();
        User returnedUser = UserData.getUserMock(userId);
        when(service.save(eq(user))).thenReturn(returnedUser);

        mvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(user.getName())))
                .andExpect(jsonPath("$.username", is(user.getUsername())))
                .andExpect(jsonPath("$.password", is(user.getPassword())))
                .andExpect(jsonPath("$.experience", is(user.getExperience())))
                .andExpect(jsonPath("$.contact", is(user.getContact())))
                .andExpect(jsonPath("$.hobby", is(user.getHobby())))
                .andReturn();
    }

    @Test
    public void insertExistentUser() throws Exception {
        User user = UserData.getUserMock();
        when(service.save(eq(user))).thenThrow(DuplicatedKeyException.class);

        mvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isConflict())
                .andReturn();
    }

    @Test
    public void updateUser() throws Exception {
        int userId = 99999;
        User user = UserData.getUserMock(userId);
        when(service.save(eq(user))).thenReturn(user);

        mvc.perform(MockMvcRequestBuilders.put(URL_TEMPLATE + userId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(user.getName())))
                .andExpect(jsonPath("$.username", is(user.getUsername())))
                .andExpect(jsonPath("$.password", is(user.getPassword())))
                .andExpect(jsonPath("$.experience", is(user.getExperience())))
                .andExpect(jsonPath("$.contact", is(user.getContact())))
                .andExpect(jsonPath("$.hobby", is(user.getHobby())))
                .andReturn();
    }

    @Test
    public void updateNonExistentUser() throws Exception {
        int userId = 99999;
        User user = UserData.getUserMock(userId);
        when(service.save(eq(user))).thenThrow(EntityNotFoundException.class);

        mvc.perform(MockMvcRequestBuilders.put(URL_TEMPLATE + userId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void updateThrowsException() throws Exception {
        int userId = 99999;
        User user = UserData.getUserMock(userId);
        when(service.save(eq(user))).thenThrow(RuntimeException.class);

        mvc.perform(MockMvcRequestBuilders.put(URL_TEMPLATE + userId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isInternalServerError())
                .andReturn();
    }

}
