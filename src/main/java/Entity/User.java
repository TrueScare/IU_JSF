package Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User implements Serializable {
    public enum Roles {
        ADMINSITRATOR,
        SCIENTIST,
        ANONYMOUS
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Roles roles;
    @OneToMany(mappedBy = "owner")
    private List<DataSet> datasets = new ArrayList<DataSet>();
    @OneToMany(mappedBy = "owner")
    private List<DataSetEntry> dataSetEntries = new ArrayList<>();

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

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = Roles.valueOf(roles);
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<DataSet> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<DataSet> datasets) {
        this.datasets = datasets;
    }

    public List<DataSetEntry> getDataSetEntries() {
        return dataSetEntries;
    }

    public void setDataSetEntries(List<DataSetEntry> dataSetEntries) {
        this.dataSetEntries = dataSetEntries;
    }
}
