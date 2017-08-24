package br.com.ssh.model;

import br.com.constant.*;
import br.com.database.model.HostDatabase;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "hostserver")
public class HostServer {
    private String hostName;
    private String name;
    private String password;
    private HostDatabase database;

    public String getHostName() {
        return hostName;
    }

    @XmlElement(name = "hostname")
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getName() {
        return name;
    }

   @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

   @XmlElement(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    public HostDatabase getDatabase() {
        return database;
    }
    @XmlElement(name = "database")
    public void setDatabase(HostDatabase database) {
        this.database = database;
    }
}