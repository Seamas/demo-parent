package wang.seamas.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import wang.seamas.model.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class UserControllerTest {

    @Autowired
    UserController controller;

    private MockMvc mockMvc;


    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    @Test
    void master() throws Exception {
        User user = Common.createUser();
        String json = Common.writeToJson(user);
        Common.postRequest(mockMvc, "/master", json);
    }

    @Test
    void slave() throws Exception {
        User user = Common.createUser();
        String json = Common.writeToJson(user);
        Common.postRequest(mockMvc, "/slave", json);
    }

    @Test
    void all() throws Exception {
        Common.getRequest(mockMvc, "/all");
    }
}