package Service;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Locale;

@Named
@SessionScoped
public class LocaleService implements Serializable {

    public Locale getUserLocale() {
        return FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }

    public String[] getAllLocales() {
        return Locale.getISOCountries();
    }

    public String getCountryByCode(String code) {
        Locale locale = new Locale("", code);
        return locale.getDisplayCountry();
    }

    public String getLanguageCodeByCode(String code) {
        Locale locale = new Locale("", code);
        return locale.getCountry();
    }
}