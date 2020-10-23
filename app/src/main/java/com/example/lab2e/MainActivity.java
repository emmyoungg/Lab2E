package com.example.lab2e;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Spinner spinner;
    private TextView twOutput;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.dropdown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.options,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter(adapter);


        editText = (EditText)findViewById(R.id.editText);

        twOutput = (TextView) findViewById(R.id.twOutput);

        res =  getResources();
    }

    public void onClickButton(View view) {
        String input = editText.getText().toString();
        if(input.equals("")) {
            Context context = getApplicationContext();
            String text = "Whoopsie you suck ";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            String spinnerOpt = spinner.getSelectedItem().toString();
            if(spinnerOpt.equals("Characters")) {
                twOutput.setText(res.getString(R.string.noChars) + WordCounter.Characters(input));
            } else if(spinnerOpt.equals("Words")) {
                //calc
                twOutput.setText(res.getString(R.string.noWords) + WordCounter.Words(input));
            }
            //
        }
    }
}