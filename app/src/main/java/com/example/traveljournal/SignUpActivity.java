package com.example.traveljournal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private TextView emailTxt, passwordTxt, reEnterPasswordTxt;
    private Button signUpBtn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailTxt = findViewById(R.id.signUp_email);
        passwordTxt = findViewById(R.id.signUp_password);
        reEnterPasswordTxt = findViewById(R.id.signUp_renterPassword);
        signUpBtn = findViewById(R.id.signUp_btn);
        mAuth = FirebaseAuth.getInstance();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }

    private void signUp() {
        String email = emailTxt.getText().toString();
        String password = passwordTxt.getText().toString();
        String reEnterPassword = reEnterPasswordTxt.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(reEnterPassword)){
            Toast.makeText(this, "Enter Email or Password fields empty! ", Toast.LENGTH_SHORT).show();
        }else if(!password.equals(reEnterPassword)){
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
        }else{
            /*TODO functionality for signing up*/
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                                emailTxt.setText("");
                                passwordTxt.setText("");
                                // Sign in success, update UI with the signed-in user's information
//                                Log.d(TAG, "createUserWithEmail:success");
//                                FirebaseUser user = mAuth.getCurrentUser();
//                                updateUI(user);
                            } else {
                                Toast.makeText(SignUpActivity.this, "Sign Up Unsuccessful", Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user.
//                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                                Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                        Toast.LENGTH_SHORT).show();
//                                updateUI(null);
                            }
                        }
                    });
        }
    }

    private void registerUser() {

    }
}