package alphatech.com.school_management_system;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;


import static android.app.Activity.RESULT_OK;

/**
 * Created by Tahir Raza on 11/04/2018.
 */

public class Crop_Image extends Fragment {
    Button btn;
    ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.crop_image, container, false);

        btn =  view.findViewById(R.id.btn_image);
        imageView =  view.findViewById(R.id.iv_profile);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageFromGallary();
            }
        });
        return view;


    }

    public void selectImageFromGallary(){
        CropImage.activity()
                .start(getContext(), this);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(getActivity(), "error:" , Toast.LENGTH_LONG).show();

        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK){

                Uri resultUri = result.getUri();
                Toast.makeText(getActivity(), "Image URI is : "+resultUri.toString(), Toast.LENGTH_LONG).show();
                imageView.setImageURI(resultUri);
            }
            else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }
    }
}

