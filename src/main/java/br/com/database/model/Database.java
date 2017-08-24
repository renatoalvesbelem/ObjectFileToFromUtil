package br.com.database.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "database")
public class Database {
    private String databaseName;
    private String databaseUser;
    private String databasePassword;

    public String getDatabaseName() {
        return databaseName;
    }
    @XmlElement(name = "databasename")
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }
    @XmlElement(name = "databaseuser")
    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    @XmlElement(name = "databasepassword")
    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }
}
