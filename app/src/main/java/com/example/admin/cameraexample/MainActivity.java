package com.example.admin.cameraexample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.File;
import java.net.URI;

public class MainActivity extends Activity {

    RelativeLayout relative_layout;
    ImageView image_view;
    static final int CAM_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relative_layout=(RelativeLayout)findViewById(R.id.relative_layout);
        image_view=(ImageView)findViewById(R.id.image_view);
        relative_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent camera_intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file=gitFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent,CAM_REQUEST);
            }
        });
    }
    private File gitFile(){

        File folder=new File("sdcard/camera_app");
        if(!folder.exists()){
            folder.mkdir();

        }
        File image_view=new File(folder,"cam_image.jpg");
        return image_view;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path="sdcard/camera_app/cam_image.jpg";
        image_view.setImageDrawable(Drawable.createFromPath(path));
    }
}
