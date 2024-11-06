package Controller.EntityController;

import Entity.DataSetEntry;
import jakarta.faces.view.ViewScoped;

import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class DataSetEntryDetailController extends BaseEntityDetailController<DataSetEntry> {

    public DataSetEntryDetailController() {
    }

    @Override
    public void saveEntity(DataSetEntry entity) {
        activeEntity.setOwner(context.getActiveUser());
        super.saveEntity(entity);
    }

    @Override
    public String getPagePath(Long id) {
        List<DataSetEntry> entries = context.getActiveUser().getDataSetEntries();
        ArrayList<Long> ids = new ArrayList<>();
        for (DataSetEntry entry : entries) {
            ids.add(entry.getId());
        }

        if (!ids.contains(id) && entityDAO.getById(id) != null) {
            return "/datasetentrychange/detail.xhtml?toBeChangedId=" + id;
        }

        return super.getPagePath(id);
    }
}
