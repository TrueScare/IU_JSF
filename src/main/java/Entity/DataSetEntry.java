package Entity;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "dataset_entry")
@Named
@ViewScoped
public class DataSetEntry implements Serializable {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "dataset")
    private DataSet dataSet;
    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;
    @OneToOne
    private DataSetEntryDetails details;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedLast;

    public DataSet getDataSet() {
        return dataSet;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public DataSetEntryDetails getDetails() {
        return details;
    }

    public void setDetails(DataSetEntryDetails details) {
        this.details = details;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedLast() {
        return updatedLast;
    }

    public void setUpdatedLast(LocalDateTime updatedLast) {
        this.updatedLast = updatedLast;
    }
}
