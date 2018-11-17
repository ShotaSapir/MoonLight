package com.example.yarden.moonlight;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserInfoActivity extends AppCompatActivity {
   private Button buttonDial;
private Button buttonSendEmail;
private TextView textViewName;
private TextView textViewEmail;
private TextView textViewPhone;
private TextView textViewGender;
private TextView textViewDate;
private ImageView imageView;
private String PhoneNumber;
private String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        init();
    }

    private void init() {
        textViewDate = findViewById(R.id.textView_date);
        textViewEmail = findViewById(R.id.textView_email);
        textViewGender = findViewById(R.id.textView_gender);
        textViewName = findViewById(R.id.textView_name);
        textViewPhone = findViewById(R.id.textView_phone_num);
        imageView = findViewById(R.id.imageView);
        buttonSendEmail = findViewById(R.id.button_send_email);
        buttonDial = findViewById(R.id.button_dial);

        Intent intent = getIntent();

        String userName = intent.getStringExtra("name");
        String userDate = intent.getStringExtra("date");
        String userGender = intent.getStringExtra("gender");
        Uri path = Uri.parse(intent.getStringExtra("photo"));
        String userPassword = intent.getStringExtra("password");
        Email = intent.getStringExtra("email");
        PhoneNumber = intent.getStringExtra("phone");

        textViewName.setText(userName);
        textViewGender.setText(userGender);
        textViewEmail.setText(Email);
        textViewDate.setText(userDate);
        textViewPhone.setText(PhoneNumber);
        imageView.setImageURI(path);

        buttonDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialerWithClientNumber();
            }
        });

        buttonSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMailToClientsMail();
            }
        });

    }

    private void sendMailToClientsMail() {
        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setDataAndType(Uri.parse(Email),"text/plain");
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Enter subject");
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Edit your message");
        try {
            startActivity(Intent.createChooser(mailIntent, "Send mail..."));
            onResume();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void openDialerWithClientNumber() {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", PhoneNumber,null));
        startActivity(dialIntent);
        onResume();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
