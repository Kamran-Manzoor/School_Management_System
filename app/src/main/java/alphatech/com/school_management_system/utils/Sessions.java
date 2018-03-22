package alphatech.com.school_management_system.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kami on 22/03/2018.
 */

public class Sessions {
    Context context;
    SharedPreferences pref;


    public Sessions(Context context){
        this.context = context;
        pref = context.getSharedPreferences(Constants.TAG_USERS, Context.MODE_PRIVATE);
    }

    private static final String USERTYPE = "userType";

    public String getUserType() {
      userType =  pref.getString(USERTYPE, userType);
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
        pref.edit().putString(USERTYPE, userType).apply();
    }

    private String userType;

}
