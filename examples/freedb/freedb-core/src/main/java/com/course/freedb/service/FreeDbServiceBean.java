package com.course.freedb.service;

import java.awt.Image;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.freedb.api.FreeDbRepository;
import com.course.freedb.api.FreeDbService;
import com.course.freedb.model.Album;
import com.course.freedb.model.AlbumFilter;
import com.course.freedb.model.Dictionary;

@Service
public class FreeDbServiceBean implements FreeDbService {

    @Autowired
    private FreeDbRepository repository;
    
    @Override
    public List<Album> findAlbum(AlbumFilter filter) {
        return null;
    }

    @Override
    public Album findAlbum(String discId) {
        for(Album album : repository.loadDictionary().getAlbums())
        {
            if (album.getDiscId().equalsIgnoreCase(discId))
            {
                return album;
            }
        }
        return null;
    }

    @Override
    public void addAlbum(Album album) {
        // FIXME idueppe - check if album already exists and throw AlbumAlreadyExistException
        Dictionary dictionary = repository.loadDictionary();
        dictionary.getAlbums().add(album);
        repository.saveDictionary(dictionary);
    }

    @Override
    public void updateAlbum(Album album) {
        Album found = findAlbum(album.getDiscId());
        if (found != null) {
            removeAlbum(found);
        }
        addAlbum(album);
    }

    @Override
    public void removeAlbum(Album album) {
        Dictionary dictionary = repository.loadDictionary();
        dictionary.getAlbums().remove(album);
        repository.saveDictionary(dictionary);
    }

    @Override
    public void addCover(String discId, Image image) {
        // TODO Auto-generated method stub

    }

}
