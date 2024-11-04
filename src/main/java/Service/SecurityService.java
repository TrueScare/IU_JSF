package Service;

import Entity.User;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

@Named
@ViewScoped
public class SecurityService implements Serializable {
    // This should always come from a config file, but for the sake of the case study this can be static
    private static final String salt = "f4s94mmMbdqSSHD03fOAywZQ9VMBFVZ90eaDATUd";

    public SecurityService() {
    }

    public boolean validateUser(User userToValidate, User userToValidateAgainst) {
        return userToValidate.getUsername().equals(userToValidateAgainst.getUsername())
                && userToValidate.getPassword().equals(userToValidateAgainst.getPassword());
    }

    public String hashPassword(String name, String password) {
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-512");
            byte[] hashedPassword = digester.digest((name + password + salt).getBytes(StandardCharsets.UTF_8));
            return new String(Base64.getEncoder().encode(hashedPassword));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
