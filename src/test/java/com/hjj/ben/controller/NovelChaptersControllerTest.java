package com.hjj.ben.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

/**
 * Created by ben on 7/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/dispatcher-servlet.xml"})
public class NovelChaptersControllerTest {

    private MockMvc mockMvc;

    @Test
    public void getCatalog() throws Exception {

    }

    @Test
    public void getChapterById() throws Exception {

    }

}