package alphatech.com.school_management_system;

import alphatech.com.school_management_system.models.ServerRequest;
import alphatech.com.school_management_system.models.ServerResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Tahir Raza on 22/03/2018.
 */

public interface RequestInterface {

    @POST("server/index.php")
    Call<ServerResponse> operation(@Body ServerRequest request);
}
