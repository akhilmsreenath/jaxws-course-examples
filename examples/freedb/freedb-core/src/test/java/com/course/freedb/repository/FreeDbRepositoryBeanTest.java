package com.course.freedb.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.course.freedb.model.Dictionary;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class FreeDbRepositoryBeanTest {

    @Autowired
    private FreeDbRepositoryBean repository;
    
    @Autowired
    private ResourceLoader resourceLoader;
    
    @Test
    public void testRepository()
    {
        Dictionary dictionary = repository.loadDictionary();
        assertNotNull(dictionary);
    }
    
    @Test
    @DirtiesContext
    public void testSaveDictionary() 
    {
        Resource tempRessource = resourceLoader.getResource("file:target/tmp-freedb.xml");
        repository.setFreeDb(tempRessource);
        repository.saveDictionary(new Dictionary());
    }
    
    
}
