package com.course.freedb.repository;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.core.io.Resource;

import com.course.freedb.api.FreeDbRepository;
import com.course.freedb.exceptions.SystemException;
import com.course.freedb.model.Dictionary;
import com.course.freedb.model.ObjectFactory;

public class FreeDbRepositoryBean implements FreeDbRepository {

    private Resource freeDb;
    
    private JAXBContext jaxbContext;
    
    public void init()
    {
        try {
            jaxbContext = JAXBContext.newInstance("com.course.freedb.model");
        } catch (JAXBException e) {
            throw new SystemException("Couldn't load data from "+freeDb.getFilename(), e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Dictionary loadDictionary() {
        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<Dictionary> element = (JAXBElement<Dictionary>) unmarshaller.unmarshal(freeDb.getInputStream());
            return element.getValue();
        } catch (JAXBException | IOException e) {
            throw new SystemException("Couldn't load data from "+freeDb.getFilename(), e);
        }
    }

    @Override
    public void saveDictionary(Dictionary dictionary) {
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            
            FileOutputStream fos = new FileOutputStream(freeDb.getFile());
            JAXBElement<Dictionary> jaxbElement = new ObjectFactory().createDictionary(dictionary);
            marshaller.marshal(jaxbElement, fos);
            fos.close();
        } catch (JAXBException | IOException e) {
            throw new SystemException("Couldn't save data to "+freeDb.getFilename(), e);
        }
    }

    public Resource getFreeDb() {
        return freeDb;
    }

    public void setFreeDb(Resource freeDb) {
        this.freeDb = freeDb;
    }

}
