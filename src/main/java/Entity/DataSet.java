package Entity;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dataset")
@Named
@ViewScoped
public class DataSet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;
    private String locale;
    @OneToMany
    private List<DataSetEntry> dataSetEntries = new ArrayList<DataSetEntry>();

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

    public List<DataSetEntry> getDataSetEntries() {
        return dataSetEntries;
    }

    public void setDataSetEntries(List<DataSetEntry> dataSetEntries) {
        this.dataSetEntries = dataSetEntries;
    }
}
