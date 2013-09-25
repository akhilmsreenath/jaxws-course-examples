package com.course.freedb.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.course.freedb.api.FreeDbService;
import com.course.freedb.model.Album;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class FreeDbServiceBeanTest {

    private static final String DISC_ID = "890cee09,8b0cef09,8b0cf009,8c0cef09,8c0cf009,8d0cef09,8d0cf009,8d0cf209,8d0cf309,920cee09";
    @Autowired
    private FreeDbService service;

    @Test
    public void testFindAlbumById() {
        Album album = service.findAlbum(DISC_ID);
        assertNotNull(album);
        assertEquals(" Brothers in Arms", album.getName());
    }

    @Test
    public void testAddAlbum() {
        Album album = new Album();
        album.setDiscId("JUNIT");
        album.setName("JUNIT_NAME");

        service.addAlbum(album);
        Album foundAlbum = service.findAlbum("JUNIT");
        assertNotNull(foundAlbum);
        assertEquals("JUNIT_NAME", foundAlbum.getName());
    }

    @Test
    public void testUpdateAlbum() {
        Album album = new Album();
        album.setDiscId("JUNIT_UPDATE");
        album.setName("JUNIT_NAME");
        
        service.addAlbum(album);
        album.setName("JUNIT_UPDATE");
        service.updateAlbum(album);
        
        Album updated = service.findAlbum("JUNIT_UPDATE");
        assertEquals("JUNIT_UPDATE", updated.getName());
        service.removeAlbum(updated);
    }

}
