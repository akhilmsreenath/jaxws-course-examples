package com.course.freedb.api;

import java.awt.Image;
import java.util.List;

import com.course.freedb.model.Album;
import com.course.freedb.model.AlbumFilter;

public interface FreeDbService {
    
    public List<Album> findAlbum(AlbumFilter filter);
    
    public Album findAlbum(String discId);
    
    public void addAlbum(Album album);
    
    public void updateAlbum(Album album);
    
    public void addCover(String discId, Image image);

    public abstract void removeAlbum(Album album);
    
}
