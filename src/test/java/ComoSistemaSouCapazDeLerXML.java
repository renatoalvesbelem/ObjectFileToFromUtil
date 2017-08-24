import br.com.ssh.model.HostServer;
import br.com.xml.controller.XMLToObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ComoSistemaSouCapazDeLerXML {
    private HostServer createXML, hostXML;
    private final String absolutePath = "d://host.xml";

    @Before
    public void makeXMLWithValues() {
        createXML = new HostServer();
        createXML.setHostName("192.168.225.140");
        createXML.setName("renato");
        createXML.setPassword("1234564");
        new XMLCreator().createXML(createXML);
    }

    @Test
    public void readAndInstanceObject() {
        hostXML = (HostServer) new XMLToObject(new HostServer(),absolutePath).instanceObjectParsed();
    }

    @After
    public void validateValues() {
        Assert.assertEquals(createXML.getHostName(), hostXML.getHostName());
        Assert.assertEquals(createXML.getName(), hostXML.getName());
        Assert.assertEquals(createXML.getPassword(), hostXML.getPassword());
        Assert.assertEquals(true, new File(absolutePath).delete());
    }
}