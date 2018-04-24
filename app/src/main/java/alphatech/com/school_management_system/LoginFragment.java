package alphatech.com.school_management_system;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import alphatech.com.school_management_system.models.Phone;
import alphatech.com.school_management_system.models.ServerRequest;
import alphatech.com.school_management_system.models.ServerResponse;
import alphatech.com.school_management_system.utils.Constants;
import alphatech.com.school_management_system.utils.Sessions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tahir Raza on 22/03/2018.
 */

public class LoginFragment extends Fragment implements View.OnClickListener{

    private AppCompatButton btn_login;
    private EditText et_number,et_password;
    private TextView tv_register;
    private ProgressBar progress;
    private SharedPreferences pref;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login,container,false);
        initViews(view);
        return view;

    }

    private void initViews(View view){

        pref = getActivity().getPreferences(0);

        btn_login = view.findViewById(R.id.btn_login);
        tv_register = view.findViewById(R.id.tv_register);
        et_number = view.findViewById(R.id.et_num_login);
        et_password = view.findViewById(R.id.et_password);

        progress = view.findViewById(R.id.progress);

        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.tv_register:
                goToRegister();
                break;

            case R.id.btn_login:
                String num = et_number.getText().toString();
                String password = et_password.getText().toString();


                if(!num.isEmpty() && !password.isEmpty()) {

                    progress.setVisibility(View.VISIBLE);
                    loginProcess(num,password);

                } else {

                    Snackbar.make(getView(), "Fields are empty !", Snackbar.LENGTH_LONG).show();
                }
                break;

        }
    }
    private void loginProcess(String num,String password){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);

        Phone phone = new Phone();
        phone.setPh_no(num);
        phone.setPass(password);
        phone.setType("Anyone");
        ServerRequest request = new ServerRequest();
        request.setOperation(Constants.LOGIN_OPERATION);
        request.setPhone(phone);
        Call<ServerResponse> response = requestInterface.operation(request);

        response.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, retrofit2.Response<ServerResponse> response) {

                ServerResponse resp = response.body();
//                Snackbar.make(getView(), resp.getMessage(), Snackbar.LENGTH_LONG).show();

                if(resp.getResult().equals(Constants.SUCCESS)){
//                    SharedPreferences.Editor editor = pref.edit();
//                    editor.putBoolean(Constants.IS_User_LOGGED_IN,true);
//                    editor.putString(Constants.EMAIL,resp.getUser().getPh_no());
//                    editor.putString(Constants.NAME,resp.getUser().getType());
//                   // editor.putString(Constants.UNIQUE_ID,resp.getUser().getUnique_id());
//                    editor.apply();
                    goToProfile();

                }
                progress.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

                progress.setVisibility(View.INVISIBLE);
                Log.d(Constants.TAG,"failed");
                Snackbar.make(getView(), t.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();

            }
        });
    }

    private void goToRegister(){

        Fragment register = new RegisterFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame,register);
        ft.commit();
    }
    private void goToProfile(){

        Intent intent = new Intent(getActivity(), DashBoardActivity.class);
        startActivity(intent);

//        Fragment profile = new ProfileFragment();
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.fragment_frame,profile);
//        ft.commit();
    }
}
