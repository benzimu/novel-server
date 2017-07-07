package com.hjj.ben.controller;

import com.hjj.ben.model.NovelChapters;
import com.hjj.ben.service.INovelChaptersService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


/**
 * Created by ben on 7/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class) //表示使用SpringTest组件进行单元测试
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/dispatcher-servlet.xml",
        "classpath*:spring/applicationContext*.xml"}) //指定bean的配置文件，加载上下文环境
public class NovelChaptersControllerTest {

    private MockMvc mockMvc;

    //如果该对象需要mock，则加上此Annotate，在这里我们就是要模拟novelChaptersService的getChapterById()行为
    @Mock
    private INovelChaptersService novelChaptersService;
    //使mock对象的使用类可以注入mock对象,在这里novelChaptersController使用了novelChaptersService（mock对象）,所以在NovelChaptersController此加上此Annotate
    @InjectMocks
    private NovelChaptersController novelChaptersController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(novelChaptersController).build();
    }

//    @Test
//    public void getCatalog() throws Exception {
//
//    }

    @Test
    public void getChapterById() throws Exception {
        //静态引入使得很像人类的语言，当...然后返回...
        when(novelChaptersService.getChapterById(13724)).thenReturn(new NovelChapters());
        //发起一个http请求. andDo（print()）: 表示打印出request和response的详细信息，便于调试。
        mockMvc.perform(get("/chapters/13724")).andDo(print());

        verify(novelChaptersService).getChapterById(13724);
    }

}