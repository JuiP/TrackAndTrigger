package com.example.reminderapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ReminderMainActivity extends AppCompatActivity {

//    private EditText user,pass;
//    private Button login;
//    private TextView register;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        user = findViewById(R.id.editText);
//        pass = findViewById(R.id.editText2);
//        login = findViewById(R.id.button);
//        register = findViewById(R.id.register);

        appDatabase = AppDatabase.geAppdatabase(ReminderMainActivity.this);

        RoomDAO roomDAO = appDatabase.getRoomDAO();
//        UsernamePassword temp = roomDAO.getLoggedInUser();
//        if(temp!=null){
            Intent intent = new Intent(ReminderMainActivity.this,MainPage.class);
            startActivity(intent);
            finish();
//        }


//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loginUser(user.getText().toString().trim(),pass.getText().toString().trim());
//            }
//        });
//
//        register.setOnClickListener        });(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,Register.class);
//                startActivity(intent);
//                finish();
//            }
//        });

    }



//    public void loginUser(String user,String pass){
//
//        RoomDAO roomDAO = appDatabase.getRoomDAO();
//        UsernamePassword temp = roomDAO.getUserwithUsername(user);
//        //Toast.makeText(this, temp.getPassword(), Toast.LENGTH_SHORT).show();
//        if(temp==null){
//            Toast.makeText(MainActivity.this,"Invalid username",Toast.LENGTH_SHORT).show();
//        }
//        else{
//            if(temp.getPassword().equals(pass)){
//                temp.setIsloggedIn(1);
//                roomDAO.Update(temp);
//                AppDatabase.destroyInstance();
//                Intent intent = new Intent(MainActivity.this,MainPage.class);
//                startActivity(intent);
//                finish();
//            }
//            else{
//                Toast.makeText(MainActivity.this,"Invalid Password",Toast.LENGTH_SHORT).show();
//            }
//        }

//    }
}
