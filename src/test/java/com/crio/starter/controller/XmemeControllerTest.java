package com.crio.starter.controller;

// import com.crio.starter.dto.XMeme;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.boot.web.server.LocalServerPort;
// import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc

public class XmemeControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getMemesTest () throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/memes")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void postMemesTestBad () throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/memes")).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void getParticularMemesTest () throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/memes" + "no")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }


}