package alphatech.com.school_management_system;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Tahir Raza on 24/04/2018.
 */

public class QuickProfile extends Fragment implements View.OnClickListener {

    CircleImageView profilepic;
    EditText proname, pronumber, proemail;
    Button create;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quickprofile, container, false);
        initviews(view);
        return view;
    }

    private void initviews (View view){

        profilepic = view.findViewById(R.id.circuler_profile);
        proname = view.findViewById(R.id.et_p_fullname);
        pronumber = view.findViewById(R.id.et_p_othernumber);
        proemail = view.findViewById(R.id.et_p_email);
        create= view.findViewById(R.id.btn_createprofile);
        create.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_createprofile:
                String name = proname.getText().toString();
                String number = pronumber.getText().toString();
                String email = proemail.getText().toString();


//                if(new Validations(getContext()).quickProfilevalidation(proname, pronumber, proemail, name, number, email)) {
//
//
//                } else {
//
//                    Snackbar.make(getView(), "Fields are empty !", Snackbar.LENGTH_LONG).show();
//                }
                break;

        }
    }

    private void gotoprofile(){

        Fragment register = new LoginFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame,register);
        ft.commit();
    }
}
