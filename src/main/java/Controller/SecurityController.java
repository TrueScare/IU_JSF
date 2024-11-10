package Controller;

import DAO.UserDAO;
import Entity.User;
import Structs.AppContext;
import Service.SecurityService;
import Structs.Message;
import Structs.Messages;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

@Named
@ViewScoped
public class SecurityController implements Serializable {
    @Inject
    AppContext context;
    @Inject
    UserDAO userDAO;
    @Inject
    SecurityService securityService;
    @Inject
    Messages messages;
    String redirectTo;

    User loginUser = new User();

    public String getLoginPagePath() {
        return "login";
    }

    public String login() {
        User userValidateAgainst = userDAO.getUserUsername(loginUser.getUsername());
        loginUser.setPassword(securityService.hashPassword(loginUser.getUsername(), loginUser.getPassword()));

        if (securityService.validateUser(loginUser, userValidateAgainst)) {
            context.setActiveUser(userValidateAgainst);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            try {
                externalContext.redirect(Objects.requireNonNullElse(redirectTo, externalContext.getRequestContextPath() + "dataset/listing.xhtml?faces-redirect=true"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        messages.addMessage("Beim anmelden ist ein Fehler aufgetreten.", Message.MessageType.ERROR);

        loginUser.setPassword("");
        return "";
    }

    public void logout() {
        // reset active user and back to homepage
        context.setActiveUser(null);

        FacesContext context = FacesContext.getCurrentInstance();
        NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
        navigationHandler.handleNavigation(context, null, "/index.xhtml?faces-redirect=true");
    }

    public User getLoginUser() {
        if (loginUser == null) {
            loginUser = new User();
        }
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    public String getRedirectTo() {
        return redirectTo;
    }

    public void setRedirectTo(String redirectTo) {
        this.redirectTo = redirectTo;
    }
}
