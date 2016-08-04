package my.com.medisys.fireapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import my.com.medisys.fireapps.chat.ChatActivity;
import my.com.medisys.fireapps.reg.RegistrationActivity;

public class MainActivity extends AppCompatActivity {

    Button signinButton;
    Button registerButton;
    EditText loginEmail;
    EditText loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signinButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.regButton);
        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
    }

    public void login(View view){

        String email = loginEmail.getText().toString().trim();
        String password = loginPassword.getText().toString().trim();

        Toast.makeText(MainActivity.this, "email : "+email+"\n"+"password : "+password, Toast.LENGTH_SHORT).show();




//        Intent intent = new Intent(this, ChatActivity.class);
//        startActivity(intent);
    }
    public void registration(View view){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}
