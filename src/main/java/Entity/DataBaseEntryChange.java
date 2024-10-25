package Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "dataset_entry_change")
public class DataBaseEntryChange implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "author")
    private User author;
    @ManyToOne
    @JoinColumn(name = "dataset_entry")
    private DataSetEntry datasetEntry;
    @ManyToOne
    @JoinColumn(name = "dataset_entry_details")
    private DataSetEntryDetails dataSetEntryDetails;
    private String comment;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
    private boolean approved;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
