package com.sudirman.projectmidsemester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Biodata extends AppCompatActivity {
    ArrayList<Mahasiswa> Arrmhs=new ArrayList<>();
    private EditText Username2;
    private EditText Nim;
    private EditText Umur;
    private EditText Password2;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Username2 = (EditText) findViewById(R.id.idUsername);
        Nim = (EditText) findViewById(R.id.idNim);
        Umur = (EditText) findViewById(R.id.idUmur);
        Password2 = (EditText) findViewById(R.id.idPassword);
        Register = (Button) findViewById(R.id.btnRegister);
    }

    private void Save(String Username, int Nim, int Umur, String Password){
        Arrmhs.add(new Mahasiswa(Username, Nim, Umur, Password));
    }

    public void register(View view) {
        String inputUsername = Username2.getText().toString();
        int inputNim = Integer.parseInt(Nim.getText().toString());
        int inputUmur = Integer.parseInt(Umur.getText().toString());
        String inputPassword = Password2.getText().toString();
        Save(inputUsername,inputNim,inputUmur,inputPassword);
        Intent intent = new Intent(Biodata.this,MainActivity.class);
        intent.putParcelableArrayListExtra("myData",Arrmhs);
        startActivity(intent);
    }
}