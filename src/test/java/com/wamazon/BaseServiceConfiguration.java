package com.wamazon;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TestMainServiceApplication.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
@TestPropertySource(locations = "classpath:test.properties")
public class BaseServiceConfiguration {


}
