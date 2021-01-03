package com.dsi31.sharedperf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mPer;
    private SharedPreferences.Editor mEdit;
    private EditText nom, mdp ;
    private Button btnLogin;
    private CheckBox mCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = (EditText) findViewById(R.id.nom);
        mdp = (EditText) findViewById(R.id.mdp);
        btnLogin = (Button) findViewById(R.id.btnlogin);
        mCheck = (CheckBox) findViewById(R.id.check);

        mPer = PreferenceManager.getDefaultSharedPreferences(this);
        mEdit = mPer.edit();

        checksharedper();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheck.isChecked())
                {
                    mEdit.putString(getString(R.string.checkbox),"True");
                    mEdit.commit();

                    //sauvgarder le nom
                    String name = nom.getText().toString();
                    mEdit.putString(getString(R.string.name),name);
                    mEdit.commit();

                    //sauvgarder le MDP
                    String password = nom.getText().toString();
                    mEdit.putString(getString(R.string.pass),password);
                    mEdit.commit();
                }
                else
                {
                    mEdit.putString(getString(R.string.checkbox),"False");
                    mEdit.commit();

                    //sauvgarder le nom
                    mEdit.putString(getString(R.string.name),"");
                    mEdit.commit();

                    //sauvgarder le MDP
                    mEdit.putString(getString(R.string.pass),"");
                    mEdit.commit();
                }
            }
        });
    }

    private void checksharedper()
    {
        String checkbox  = mPer.getString(getString(R.string.checkbox),"False");
        String Name  = mPer.getString(getString(R.string.name),"");
        String pass  = mPer.getString(getString(R.string.pass),"");

        nom.setText(Name);
        mdp.setText(pass);
        if (checkbox.equals("True"))
        {
            mCheck.setChecked(true);
        }
        else
        {
            mCheck.setChecked(false);
        }
    }
}