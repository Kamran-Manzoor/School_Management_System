package alphatech.com.school_management_system.models;

/**
 * Created by Tahir Raza on 22/03/2018.
 */

public class ServerResponse {
    private String result;
    private String message;
    private Phone phone;

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public Phone getUser() {
        return phone;
    }
}
