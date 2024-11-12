package Controller.EntityController;

import Entity.User;
import Service.SecurityService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class UserController extends BaseEntityDetailController<User> {
    @Inject
    SecurityService securityService;

    public UserController() {

    }

    public void setupUsers(){
        String[] usernames = new String[]{"user1", "user2", "user3", "user4", "user5"};
        for(String username : usernames){
            User user = new User();
            user.setUsername(username);
            user.setPassword(securityService.hashPassword(username, "password"));
            entityDAO.save(user);
        }
    }
}
