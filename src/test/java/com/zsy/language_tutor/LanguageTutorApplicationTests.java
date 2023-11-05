package com.zsy.language_tutor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsy.language_tutor.enums.SpeakingTaskType;
import com.zsy.language_tutor.model.SpeakingTask;
import com.zsy.language_tutor.service.SpeakingTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@AutoConfigureMockMvc
class LanguageTutorApplicationTests {

    @Resource
    private MockMvc mockMvc;

    @MockBean
    private SpeakingTaskService speakingTaskService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetSpeakingTask() throws Exception {
        SpeakingTask task = new SpeakingTask();
        task.setId(1);
        task.setTitle("Test Title");
        // ... set other fields ...

        given(this.speakingTaskService.selectByPrimaryKey(1)).willReturn(task);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/speaking-task/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Test Title"));
        // ... check other fields ...
    }

    @Test
    public void testCreateSpeakingTask() throws Exception {
        SpeakingTask task = new SpeakingTask();
        task.setTitle("Task1");
        task.setTaskType(SpeakingTaskType.TASK_1.getValue());
        task.setContent("Task1 Content");

        given(this.speakingTaskService.insert(any(SpeakingTask.class))).willReturn(1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/speaking-task")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(task)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testUpdateSpeakingTask() throws Exception {
        SpeakingTask task = new SpeakingTask();
        task.setId(1);
        task.setTitle("Updated Title");

        given(this.speakingTaskService.updateByPrimaryKey(task));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/speaking-task/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(task)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Updated Title"));
    }

    @Test
    public void testDeleteSpeakingTask() throws Exception {
        given(this.speakingTaskService.deleteByPrimaryKey(1)).willReturn(1);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/speaking-task/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
