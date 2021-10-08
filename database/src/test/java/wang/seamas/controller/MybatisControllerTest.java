package wang.seamas.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import wang.seamas.model.User;

@SpringBootTest
@WebAppConfiguration
class MybatisControllerTest {

    @Autowired
    MybatisController controller;

    private MockMvc mockMvc;



    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void create() throws Exception {
        User user = Common.createUser();
        String json = Common.writeToJson(user);
        Common.postRequest(mockMvc,"/mybatis/create", json);
    }

    @Test
    public void delete() throws Exception {
        User user = Common.createUser();
        String json = Common.writeToJson(user);
        Common.postRequest(mockMvc,"/mybatis/delete", json);
    }

    @Test
    public void delteAll() throws Exception {
        Common.postRequest(mockMvc,"/mybatis/deleteAll");
    }
}