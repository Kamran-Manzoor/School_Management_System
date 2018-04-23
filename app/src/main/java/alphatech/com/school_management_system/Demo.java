package alphatech.com.school_management_system;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import alphatech.com.school_management_system.DashBoardActivity;
import alphatech.com.school_management_system.R;
import alphatech.com.school_management_system.RegisterFragment;
import alphatech.com.school_management_system.utils.Sessions;

/**
 * Created by Tahir Raza on 20/04/2018.
 */

public class Demo extends Fragment implements View.OnClickListener{

    Sessions sessions;
    Button bn_a, bn_s, bn_p,bn_t ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo, container, false);

        sessions= new Sessions(getContext());
        initviews(view);
        return view;

    }

    private void initviews(View view)
    {
        bn_a =  view.findViewById(R.id.btn_admin);
        bn_s =  view.findViewById(R.id.btn_student);
        bn_p =  view.findViewById(R.id.btn_parent);
        bn_t =  view.findViewById(R.id.btn_teacher);


        bn_a.setOnClickListener(this);
        bn_s.setOnClickListener(this);
        bn_p.setOnClickListener(this);
        bn_t.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_admin:
                sessions.setUserType("admin");
                gotodashboard();
                break;

            case R.id.btn_student:
                sessions.setUserType("user");
                gotodashboard();
                break;

            case R.id.btn_parent:
                sessions.setUserType("parent");
                gotodashboard();
                break;

            case R.id.btn_teacher:
                sessions.setUserType("teacher");
                gotodashboard();
                break;
        }
    }

    private void gotodashboard(){

        Fragment dash = new DashBoardActivity();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame,dash);
        ft.commit();
    }

}
