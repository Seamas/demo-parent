package wang.seamas.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import wang.seamas.model.User;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class Common {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String writeToJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public static User createUser() {
        User user = new User();
        user.setName("hello");
        user.setAge(10);
        return user;
    }

    public static void postRequest(MockMvc mockMvc, String url) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    public static void postRequest(MockMvc mockMvc, String url, String json) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json)
        ).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    public static void getRequest(MockMvc mockMvc, String url) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
