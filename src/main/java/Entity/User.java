package Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User implements Serializable {
    public enum Roles {
        ADMINISTRATOR,
        SCIENTIST
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String roles;
    @OneToMany(mappedBy = "owner")
    private List<DataSetEntry> dataSetEntries = new ArrayList<>();
    @OneToMany(mappedBy = "author")
    private List<DataSetEntryChange> dataSetEntryChanges = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String[] getRoles() {
        return roles.split(",");
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setRoles(Roles[] roles) {
        StringBuilder s = new StringBuilder();
        for (Roles role : roles) {
            s.append(role.name());
            if (role.equals(roles[roles.length - 1])) {
                s.append(",");
            }
        }
        this.roles = s.toString();
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
}
