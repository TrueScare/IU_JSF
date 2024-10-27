import Entity.DataSet;
import Entity.User;
import jakarta.enterprise.context.SessionScoped;

import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class Context implements Serializable {
    private User activeUser;

    public Context() {
    }
}
