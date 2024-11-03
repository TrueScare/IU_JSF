package Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dataset_entry_details")
public class DataSetEntryDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "dataset_entry")
    private DataSetEntry dataSetEntry;
    @OneToMany(mappedBy = "dataSetEntryDetails")
    private List<DataSetEntryChange> dataSetEntryChanges = new ArrayList<DataSetEntryChange>();
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

    public List<DataSetEntryChange> getDataSetEntryChanges() {
        return dataSetEntryChanges;
    }

    public void setDataSetEntryChanges(List<DataSetEntryChange> dataSetEntryChanges) {
        this.dataSetEntryChanges = dataSetEntryChanges;
    }
}
