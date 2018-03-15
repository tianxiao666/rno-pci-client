package com.hgicreate.rno.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hgicreate.rno.service.dto.AbstractTaskDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskResourceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private JacksonTester<AbstractTaskDTO> json;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void findByType() throws Exception {
        MockHttpServletResponse result = mockMvc.perform(
                get("/tasks/find-by-type/RNO_PCI_AFP_PLAN")
                        .contentType(MediaType.parseMediaType("application/json;charset=UTF-8"))
        ).andExpect(status().isOk()).andReturn().getResponse();
        System.out.println(result.getStatus());
        System.out.println(result.getContentAsString());
    }
}