package my.com.medisys.fireapps;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import my.com.medisys.fireapps.chat.ChatActivity;
import my.com.medisys.fireapps.reg.RegistrationActivity;

public class MainActivity extends AppCompatActivity {

    private Button signinButton;
    private Button registerButton;
    private EditText loginEmail;
    private EditText loginPassword;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*@description
         * here register button text and others
         *
         *
         */
        signinButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.regButton);
        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPassword = (EditText) findViewById(R.id.loginPassword);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    /*
     * use for login to onClick on signin button
     */
    public void login(View view){

        String email = loginEmail.getText().toString().trim();
        String password = loginPassword.getText().toString().trim();

//        Toast.makeText(MainActivity.this, "email : "+email+"\n"+"password : "+password, Toast.LENGTH_SHORT).show();
//        progressDialog.setMessage("please wait....");
//        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Sucessfully login", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Bad Credintials", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    /*
     * use for registration to onClick on registration button
     */
    public void registration(View view){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}
