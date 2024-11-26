package Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User implements Serializable {
    @Id
    private String username;
    private String password;
    @Column(name = "is_admin")
    private boolean admin = false;
    @OneToMany(mappedBy = "owner")
    private List<DataSetEntry> dataSetEntries = new ArrayList<>();
    @OneToMany(mappedBy = "author")
    private List<DataSetEntryChange> dataSetEntryChanges = new ArrayList<>();

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<DataSetEntry> getDataSetEntries() {
        return dataSetEntries;
    }

    public void setDataSetEntries(List<DataSetEntry> dataSetEntries) {
        this.dataSetEntries = dataSetEntries;
    }

    public List<DataSetEntryChange> getDataSetEntryChanges() {
        return dataSetEntryChanges;
    }

    public void setDataSetEntryChanges(List<DataSetEntryChange> dataSetEntryChanges) {
        this.dataSetEntryChanges = dataSetEntryChanges;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
