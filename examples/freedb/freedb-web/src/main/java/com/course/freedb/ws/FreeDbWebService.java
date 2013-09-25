package com.course.freedb.ws;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.freedb.api.FreeDbService;
import com.course.freedb.model.Album;

@Service
@WebService
public class FreeDbWebService {
    
    @Autowired
    private FreeDbService freeDbService;

    public Album findAlbum(String discId) {
        return freeDbService.findAlbum(discId);
    }

    public void addAlbum(Album album) {
        freeDbService.addAlbum(album);
    }

    public void updateAlbum(Album album) {
        freeDbService.updateAlbum(album);
    }

    public void removeAlbum(Album album) {
        freeDbService.removeAlbum(album);
    }

}
