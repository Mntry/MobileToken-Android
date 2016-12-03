package co.monetary.mobiletokendemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.monetary.mobiletoken.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getTokenPressed(View v) {
        Intent tokenIntent = new Intent(this, MonetaryTokenizerActivity.class);
        tokenIntent.putExtra("publicKey", "[Public Key Goes Here]");
        startActivityForResult(tokenIntent, MonetaryTokenizerActivity.MONETARY_TOKENIZER_REQUEST);
    }

}
