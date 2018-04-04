package alphatech.com.school_management_system.models;

/**
 * Created by Tahir Raza on 22/03/2018.
 */

public class ServerRequest {
    private String operation;
    private Phone phone;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
