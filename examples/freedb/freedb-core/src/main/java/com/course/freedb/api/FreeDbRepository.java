package com.course.freedb.api;

import com.course.freedb.model.Dictionary;

public interface FreeDbRepository {
    
    public Dictionary loadDictionary();
    
    public void saveDictionary(Dictionary dictionary);

}
