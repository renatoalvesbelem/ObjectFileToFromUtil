import br.com.constant.DatabaseType;
import br.com.database.model.Database;
import br.com.database.model.HostDatabase;

import br.com.objectfile.json.JsonToObject;
import br.com.ssh.model.HostServer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ComoSistemaSouCapazDeLerJSonComplexo {
    private HostServer createJson, hostJSON;
    private final String absolutePath = "d://host.json";
    private List<Database> databases;
    private HostDatabase hostDatabase;
    private HostServer hostServer = new HostServer();

    @Before
    public void makeXMLWithValues() throws IOException {
        createJson = new HostServer();
        hostDatabase = new HostDatabase();
        Database database = new Database();
        database.setDatabaseName("192.168.225.1");
        database.setDatabasePassword("12345678");
        database.setDatabaseUser("renato");
        Database database2 = new Database();
        database2.setDatabaseName("192.168.225.1");
        database2.setDatabasePassword("12345678");
        database2.setDatabaseUser("renato");

        databases = new ArrayList<Database>();
        databases.add(database);
        databases.add(database2);

        hostDatabase.setDatabaseType(DatabaseType.ORACLE);
        hostDatabase.setDatabaseName(databases);

        hostServer.setHostName("192.168.225.0");
        hostServer.setName("renatohost");
        hostServer.setPassword("123");
        hostServer.setDatabase(hostDatabase);



        String jsonInString = new GsonBuilder().setPrettyPrinting().create().toJson(hostServer);
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

    }
}