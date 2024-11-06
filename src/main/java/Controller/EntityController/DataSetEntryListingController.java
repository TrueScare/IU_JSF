package Controller.EntityController;

import DAO.DataSetEntryDAO;
import Entity.DataSetEntry;
import Service.LocaleService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Collection;
import java.util.Locale;

@Named
@RequestScoped
public class DataSetEntryListingController extends BaseEntityListingController<DataSetEntry> {
    @Inject
    LocaleService localeService;
    @Inject
    DataSetEntryDAO entityDAO;

    public DataSetEntryListingController() {
    }

    @Override
    public Collection<DataSetEntry> getListing() {
        if (context.getActiveUser() != null) {
            return super.getListing();
        }

        return entityDAO.getListingByLocale(localeService.getUserLocale());
    }
}
