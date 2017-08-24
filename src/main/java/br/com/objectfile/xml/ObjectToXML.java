package br.com.objectfile.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ObjectToXML {
	

    public void createXML(Object objectXML, String absolutePath) {
        Object object = (Object) objectXML;
        
        try {
            File file = new File(absolutePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Class.forName(object.getClass().getCanonicalName()));
            
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, file);
            jaxbMarshaller.marshal(object, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }


}