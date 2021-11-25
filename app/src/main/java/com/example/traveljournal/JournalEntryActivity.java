package com.example.traveljournal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.HashMap;

public class JournalEntryActivity extends AppCompatActivity {

    private Uri imageUri;
    private String imageUrl;


    private ImageView imageAdded;
    private  Button cameraBtn, closeBtn;
    CropImageView cropImageView;
    private EditText description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_entry);
        cropImageView = findViewById(R.id.cropImageView);
        description = findViewById(R.id.entryDescription);
        imageAdded = findViewById(R.id.displayImageView);
        cameraBtn = findViewById(R.id.cameraBtn);
        closeBtn = findViewById(R.id.galleryBtn);


        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(JournalEntryActivity.this, "Gallery button clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(JournalEntryActivity.this, MainActivity.class));
                finish();
            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                upload();
            }
        });

        CropImage.activity().setGuidelines(CropImageView.Guidelines.ON).start(this);
        cropImageView.setImageUriAsync(imageUri);
        imageAdded.setImageURI(imageUri);

//
//        @Override
//        public void  (int requestCode, int resultCode, Intent data) {
//            super
//            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
//                CropImage.ActivityResult result = CropImage.getActivityResult(data);
//                if (resultCode == RESULT_OK) {
//                    Uri resultUri = result.getUri();
//                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
//                    Exception error = result.getError();
//                }
//            }
//        }
    }
//

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                imageUri = resultUri;
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

//    private void upload() {
//        ProgressDialog pd = new ProgressDialog(this);
//        pd.setMessage("Uploading");
//        pd.show();
//
//        if(imageUri != null){
//            //Storing the image in firestore
//            final StorageReference filePath = FirebaseStorage.getInstance().getReference("Entries").child(System.currentTimeMillis() + "." + getFileExtension(imageUri));
//
//            StorageTask uploadTask = filePath.putFile(imageUri);
//
//            uploadTask.continueWithTask(new Continuation() {
//                @Override
//                public Object then(@NonNull Task task) throws Exception {
//                    if(!task.isSuccessful()){
//                        throw task.getException();
//                    }
//                    return filePath.getDownloadUrl();
//                }
//            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
//                @Override
//                public void onComplete(@NonNull Task<Uri> task) {
//                    Uri downloadUri = task.getResult();
//                    imageUrl = downloadUri.toString();
//                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Entries");
//                    String entryId = ref.push().getKey();
//
//                    HashMap<String, Object> map = new HashMap<>();
//                    map.put("entrid", entryId);
//                    map.put("imageurl", imageUrl);
//                    map.put("description", description.getText().toString());
//                    map.put("publisher", FirebaseAuth.getInstance().getCurrentUser().getUid());
//
//                    ref.child(entryId).setValue(map);
//
//
//                    pd.dismiss();
//                    startActivity(new Intent(JournalEntryActivity.this, MainActivity.class));
//                    finish();
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(JournalEntryActivity.this, "Try again", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }else{
//            Toast.makeText(JournalEntryActivity.this, "No image selected", Toast.LENGTH_SHORT).show();
//
//        }
//    }
//
//    private String getFileExtension(Uri uri) {
//        return MimeTypeMap.getSingleton().getExtensionFromMimeType(this.getContentResolver().getType(uri));
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
//            CropImage.ActivityResult result = CropImage.getActivityResult(data);
//            imageUri = result.getUri();
//
//            imageAdded.setImageURI(imageUri);
//        } else {
//            Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
////            startActivity(new Intent(JournalEntryActivity.this , MainActivity.class));
//            finish();
//        }
//    }
}

