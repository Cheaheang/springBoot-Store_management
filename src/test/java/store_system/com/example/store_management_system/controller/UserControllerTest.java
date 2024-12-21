package store_system.com.example.store_management_system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import store_system.com.example.store_management_system.entity.User;
import store_system.com.example.store_management_system.form.CreateUserForm;
import store_system.com.example.store_management_system.service.UserService;
import store_system.com.example.store_management_system.view.UserView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.List;

public class UserControllerTest {

    private MockMvc mockMvc;
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testList() throws Exception{
        List<UserView> userViews = List.of(new UserView("heang","admin","active","123"));
        when(userService.getUser()).thenReturn(userViews);

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(userViews);

        mockMvc.perform(get("/users").param("name","role","status","password"))
                .andExpect(status().isOk())
                .andExpect(content().json(result));
    }

    @Test
    void testCreateNameInvalid() throws Exception{
        CreateUserForm form = new CreateUserForm("", "user", "status", "1234");
        UserView userView = new UserView("test", "USER" , "active", "123");

        when(userService.createUser(any(CreateUserForm.class))).thenReturn(userView);

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(userView);
        String formJson = objectMapper.writeValueAsString(form);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(formJson))
                .andExpect(status().isOk())
                .andExpect(content().json(result));

    }

}
