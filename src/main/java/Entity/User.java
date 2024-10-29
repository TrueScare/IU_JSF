package Entity;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Named
@ViewScoped
public class User implements Serializable {
    public enum Roles {
        ADMINSITRATOR,
        SCIENTIST
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Roles roles;
    @OneToMany
    private ArrayList<DataSet> datasets;
    @OneToMany
    private ArrayList<DataSetEntry> dataSetEntries;

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
}
