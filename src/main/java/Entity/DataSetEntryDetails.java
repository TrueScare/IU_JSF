package Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "dataset_entry_details")
public class DataSetEntryDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private DataSetEntry dataSetEntry;
    @OneToMany
    private ArrayList<DataBaseEntryChange> dataBaseEntryChanges;
    private String description;
    private float emission;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public DataSetEntry getDataSetEntry() {
        return dataSetEntry;
    }

    public void setDataSetEntry(DataSetEntry dataSetEntry) {
        this.dataSetEntry = dataSetEntry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getEmission() {
        return emission;
    }

    public void setEmission(float emission) {
        this.emission = emission;
    }
}
