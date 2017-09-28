package com.shibuyaxpress.mbrt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private ArrayList<User> list;
    private EditText txtUser,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUser=findViewById(R.id.txt_user);
        txtPassword=findViewById(R.id.txt_password);

    }

    public void ValidateUsers(View view){
        int cont=1;
        UserRepository.getInstance().setListUsers();
        list=UserRepository.getInstance().getUsers();
        String user=txtUser.getText().toString();
        String password=txtPassword.getText().toString();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getUsername().equals(user)&&list.get(i).getPassword().equals(password)){
                //inicio de sesion exitoso
                User.getInstance().setName(list.get(i).getName());
                User.getInstance().setLastName(list.get(i).getLastName());
                User.getInstance().setPassword(list.get(i).getPassword());
                User.getInstance().setRole(list.get(i).getRole());
                User.getInstance().setUsername(list.get(i).getUsername());
                User.getInstance().setImgprofile(list.get(i).getImgprofile());
                //incio launcher activity
                Intent launcher=new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(launcher);
            }else {

                if (cont == list.size()) {
                    Toast.makeText(getApplicationContext(), "ingreso incorrecto", Toast.LENGTH_SHORT).show();
                    cont++;
                }
            }
        }
    }
}
