package com.example.familytree.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.familytree.utils.TestResources;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createsLonelyIndividual() throws Exception {
        mockMvc.perform(post("/person")
                                .contentType(APPLICATION_JSON)
                                .accept(APPLICATION_JSON)
                                .content(TestResources.get("post_1.json")))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Jonh Doe")))
               .andExpect(content().string(containsString("id")));
    }

    @Test
    void getsAllRelatives() throws Exception {
        mockMvc.perform(get("/person/6")) //Mrs Smith
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Cynthia Maria Hawes"))) //mom
               .andExpect(content().string(containsString("Daniel B. Wesson"))) //dad
               .andExpect(content().string(containsString("Mrs Smith"))) //herself
               .andExpect(content().string(containsString("Smith Jr"))) //son
               .andExpect(content().string(containsString("Mowgli"))); //bastard

        mockMvc.perform(get("/person/5")) //Mr Smith
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Horace Smith"))) //mom
               .andExpect(content().string(containsString("Eliza Foster"))) //dad
               .andExpect(content().string(containsString("Mr Smith"))) //himself
               .andExpect(content().string(containsString("Smith Jr"))); //son
    }
}