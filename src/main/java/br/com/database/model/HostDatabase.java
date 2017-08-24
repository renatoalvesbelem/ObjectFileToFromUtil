package br.com.database.model;

import br.com.constant.DatabaseType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "hostdatabase")
public class HostDatabase {
    private DatabaseType databaseType;
    private List<Database> databaseName;

    public DatabaseType getDatabaseType() {
        return databaseType;
    }

    @XmlElement(name = "databasetype")
    public void setDatabaseType(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }


    public List<Database> getDatabaseName() {
        return databaseName;
    }

    @XmlElement(name = "database")
    public void setDatabaseName(List<Database> databaseName) {
        this.databaseName = databaseName;
    }
}
