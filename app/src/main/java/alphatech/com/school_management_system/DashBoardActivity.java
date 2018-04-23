package alphatech.com.school_management_system;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import alphatech.com.school_management_system.utils.Constants;
import alphatech.com.school_management_system.utils.Sessions;


public class DashBoardActivity extends Fragment {

    NestedScrollView nestedScrollViewadmin, nestedScrollViewstudent, nestedScrollViewparent,nestedScrollViewteacher;
    Sessions session;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

//        if (value.equals(Constants.ADMIN) ) {
//            view = inflater.inflate(R.layout.admin_dashboard, container, false);
//
//        } else {
//            view = inflater.inflate(R.layout.student_dashboard, container, false);
//        }
//        Toast.makeText(getActivity(),  "session vaule" +session.getUserType(), Toast.LENGTH_LONG).show();
//
        return setview( inflater, container);
        }

        public  View setview( LayoutInflater layoutInflater, ViewGroup container)
        {
            session = new Sessions(getContext());
            String value= session.getUserType();

            if (value.equals(Constants.ADMIN)){
              view =  layoutInflater.inflate(R.layout.admin_dashboard, container, false);
            } else {
                if (value.equals(Constants.STUDENT)){
                    view =  layoutInflater.inflate(R.layout.student_dashboard, container, false);
                } else{
                    if (value.equals(Constants.PARENT)){
                        view =  layoutInflater.inflate(R.layout.parent_dashboard, container, false);

                    } else{
                        view =  layoutInflater.inflate(R.layout.teacher_dashboard, container, false);

                    }
                }
            }
                return view;
        }


}
