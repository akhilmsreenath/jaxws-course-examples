package com.course.freedb.model;

public class AlbumComparable extends Album {

    @Override
    public int hashCode() {
        return discId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Album)
        {
            return discId.equals(((Album)obj).discId);
        }
        return super.equals(obj);
    }
    
}
