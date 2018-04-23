package alphatech.com.school_management_system;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kami on 21/03/2018.
 */


public class Fragment_QuickProfile extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quickprofile, container, false);
        return view;

    }
}
