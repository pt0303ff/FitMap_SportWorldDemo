package com.example.sportsworlddemo1.rehabilitation.anklepage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.sportsworlddemo1.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RehabilitationAnklePullUp extends AppCompatActivity {
    private static final int REQUEST_CODE = 22;
    Button btnpicture;
    ImageView imageView;
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rehabilitation_ankle_pullup);

        btnpicture = findViewById(R.id.button6);
        imageView = findViewById(R.id.imageView7);
        btnpicture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activityResultLauncher.launch(cameraIntent);
            }
        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {

            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        Bundle extras = data.getExtras();
                        if (extras != null) {
                            Bitmap imageBitmap = (Bitmap) extras.get("data");
                            if (imageBitmap != null) {
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(imageBitmap, imageBitmap.getWidth(), imageBitmap.getHeight(), false);
                                Bitmap copiedBitmap = scaledBitmap.copy(Bitmap.Config.RGB_565, true);
                                Uri imageUri = saveImage(copiedBitmap, RehabilitationAnklePullUp.this);
                                imageView.setImageURI(imageUri);
                            } else {
                                // 处理图像数据为空的情况
                            }
                        } else {
                            // 处理额外数据为空的情况
                        }
                    } else {
                        // 处理返回的Intent为空的情况
                    }
                } else {
                    // 处理返回结果不为RESULT_OK的情况
                }
            }
        });
    }

    private Uri saveImage(Bitmap image, RehabilitationAnklePullUp context) {

        File imagefolder = new File(context.getCacheDir(), "images");
        Uri uri = null;
        try{
            imagefolder.mkdirs();
            File file = new File(imagefolder, "captured_image.jpg");
            FileOutputStream stream = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            stream.flush();
            stream.close();
            uri = FileProvider.getUriForFile(context.getApplicationContext(), "com.allcodingtutorial.camerafull1"+".provider", file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uri ;

    }
}
