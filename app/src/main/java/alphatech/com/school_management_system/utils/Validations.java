package alphatech.com.school_management_system.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import alphatech.com.school_management_system.R;

/**
 * Created by kami on 22/03/2018.
 */

public class Validations {
    private static final int pass_min_length = 4;
    private static final int name_min_length = 3;
    private static final int name_max_length = 20;


    Context context;



    public Validations(Context context){
        this.context = context;
    }



//    public boolean loginValidation(EditText editText , EditText editText1, String email, String password){
//
//        boolean isEmailEntered = !TextUtils.isEmpty(email.trim());
//        boolean isPasswordEntered = !TextUtils.isEmpty(password.trim());
//
//        if (isEmailEntered && isPasswordEntered){
//            boolean valid = true;
//            if(!isEmailValid(email)){
//                valid = false;
//                editText.setError(context.getString(R.string.email_error));
//            }
//            if(password.length() < pass_min_length){
//                valid = false;
//                editText1.setError(context.getString(R.string.pass_min_error));
//            }
//            return valid;
//        }else if (!isEmailEntered && !isPasswordEntered){
//            editText.setError(context.getString(R.string.feilds_empty));
//            editText1.setError(context.getString(R.string.feilds_empty));
//        }
//        else {
//            if(!isEmailEntered){
//                editText.setError(context.getString(R.string.email_empty));
//            }
//            if (!isPasswordEntered){
//                editText1.setError(context.getString(R.string.password_empty));
//            }
//        }
//
//        return false;
//    }

//    public boolean registerValidation(EditText etname, EditText etemail, EditText etpassword, EditText etConfirmPassword,
//                                      String name, String email, String password, String confrimPassword) {
//        boolean isNameEntered = !TextUtils.isEmpty(name.trim());
//        boolean isEmailEntered = !TextUtils.isEmpty(email.trim());
//        boolean isPasswordEntered = !TextUtils.isEmpty(password.trim());
//        boolean isConfirmPassEntered = !TextUtils.isEmpty(confrimPassword.trim());
//
//        if (isNameEntered && isEmailEntered && isPasswordEntered && isConfirmPassEntered) {
//            boolean validy = true;
//            if (name.length() < name_min_length || name.length() > name_max_length) {
//                validy = false;
//                etname.setError(context.getString(R.string.name_length_error));
//            }
//            if (!isEmailValid(email)) {
//                validy = false;
//                etemail.setError(context.getString(R.string.email_error));
//            }
//            if (password.length() < pass_min_length) {
//                validy = false;
//                etpassword.setError(context.getString(R.string.pass_min_error));
//            }
//            if (!Objects.equals(password, confrimPassword)) {
//                validy = false;
//                etConfirmPassword.setError(context.getString(R.string.password_unmatch));
//            }
//
//            return validy;
//        } else if (!isNameEntered && !isEmailEntered && !isPasswordEntered && !isConfirmPassEntered) {
//            etname.setError(context.getString(R.string.feilds_empty));
//            etemail.setError(context.getString(R.string.feilds_empty));
//            etpassword.setError(context.getString(R.string.feilds_empty));
//            etConfirmPassword.setError(context.getString(R.string.feilds_empty));
//
//        } else {
//            if (!isNameEntered) {
//                etname.setError(context.getString(R.string.name_empty));
//            }
//            if (!isEmailEntered) {
//                etemail.setError(context.getString(R.string.email_empty));
//            }
//            if (!isPasswordEntered) {
//                etpassword.setError(context.getString(R.string.password_empty));
//            }
//            if (!isConfirmPassEntered) {
//                etConfirmPassword.setError(context.getString(R.string.confirmpassword_empty));
//            }
//        }
//
//
//        return false;
//    }

//    public boolean isEmailValid(String email){
//        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
//        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }
}
