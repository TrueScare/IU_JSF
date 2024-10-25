package Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class DataSet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;
    private String locale;
    @OneToMany
    private ArrayList<DataSetEntry> dataSetEntries;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
