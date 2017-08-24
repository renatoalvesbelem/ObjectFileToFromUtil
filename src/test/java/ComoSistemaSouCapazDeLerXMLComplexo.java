import br.com.constant.DatabaseType;
import br.com.database.model.Database;
import br.com.database.model.HostDatabase;
import br.com.ssh.model.HostServer;
import br.com.xml.controller.XMLToObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComoSistemaSouCapazDeLerXMLComplexo {
    private HostServer createXML, hostXML;
    private final String absolutePath = "d://host.xml";
    private HostServer hostServer = new HostServer();
    private List<Database> databases;
    private HostDatabase hostDatabase;

    @Before
    public void makeXMLWithValues() {
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
        createXML.setDatabase(hostDatabase);


hostServer.setDatabase(hostDatabase);
        hostServer.setHostName("192.168.225.0");
        hostServer.setName("renatohost");
        hostServer.setPassword("123");

        new XMLCreator().createXML(hostServer);
    }

    @Test
    public void readAndInstanceObject() {
        hostXML = (HostServer) new XMLToObject(new HostDatabase(), absolutePath).instanceObjectParsed();
    }

    @After
    public void validateValues() {

    }
}