package com.hgicreate.rno.web.rest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "eureka.client.enabled=false")
@AutoConfigureMockMvc
public class ThresholdResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAll() throws Exception {
        MockHttpServletResponse result = this.mockMvc.perform(
                get("/api/thresholds")
                        .param("defaultValue", "0.1")
                        .contentType(MediaType.parseMediaType("application/json;charset=UTF-8"))
        ).andExpect(status().isOk()).andReturn().getResponse();
        System.out.println(result.getStatus());
        System.out.println(result.getContentAsString());
    }
}