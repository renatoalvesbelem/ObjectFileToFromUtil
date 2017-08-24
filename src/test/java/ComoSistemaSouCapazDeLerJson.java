import br.com.objectfile.json.JsonToObject;
import br.com.ssh.model.HostServer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ComoSistemaSouCapazDeLerJson {
    private HostServer createJson, hostJSON;
    private final String absolutePath = "d://host.json";

    @Before
    public void makeXMLWithValues() throws IOException {
        createJson = new HostServer();
        createJson.setHostName("192.168.225.140");
        createJson.setName("renato");
        createJson.setPassword("1234564");
        String jsonInString = new GsonBuilder().setPrettyPrinting().create().toJson(createJson);
        FileWriter file = new FileWriter(absolutePath, false);
        file.write(jsonInString);
        file.close();

    }

    @Test
    public void readAndInstanceObject() {
        hostJSON = (HostServer) new JsonToObject(new HostServer(), absolutePath).instanceObjectParsed();

    }

    @After
    public void validateValues() {
        Assert.assertEquals(createJson.getHostName(), hostJSON.getHostName());
        Assert.assertEquals(createJson.getName(), hostJSON.getName());
        Assert.assertEquals(createJson.getPassword(), hostJSON.getPassword());
        Assert.assertEquals(true, new File(absolutePath).delete() );
    }
}