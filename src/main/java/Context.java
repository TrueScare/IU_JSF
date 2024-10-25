import Entity.DataSet;
import jakarta.enterprise.context.SessionScoped;

import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class Context implements Serializable {
    public Context() {
    }
}
