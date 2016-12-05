package co.monetary.mobiletokendemo;

import android.app.AlertDialog;
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == MonetaryTokenizerActivity.MONETARY_TOKENIZER_REQUEST)
        {
            if (resultCode == MonetaryTokenizerActivity.RESULT_SUCCESS)
            {
                MonetaryToken token = (MonetaryToken)data.getSerializableExtra("token");
                new AlertDialog.Builder(this)
                        .setTitle("Token Response")
                        .setMessage("Token: " + token.token + "\nLast 4: " + token.last4 + "\nExp Month: " + token.expirationMonth + "\nExp Year: " + token.expirationYear + "\nBrand: " + token.brand)
                        .setNeutralButton("OK", null).show();
            }
            else if (resultCode == MonetaryTokenizerActivity.RESULT_ERROR)
            {
                MonetaryTokenizationError error = (MonetaryTokenizationError)data.getSerializableExtra("error");
                new AlertDialog.Builder(this)
                        .setTitle("Tokenization Error")
                        .setMessage("Error Code: " + error.errorCode.toString() + "\nError Message: " + error.errorMessage)
                        .setNeutralButton("OK", null).show();

            }
            else if (resultCode == MonetaryTokenizerActivity.RESULT_CANCELED)
            {
                new AlertDialog.Builder(this)
                        .setTitle("Tokenization Cancelled")
                        .setMessage("Tokenization Cancelled")
                        .setNeutralButton("OK", null).show();

            }
        }
    }

    public void getTokenPressed(View v) {
        Intent tokenIntent = new Intent(this, MonetaryTokenizerActivity.class);
        tokenIntent.putExtra("publicKey", "test_public0CC030338D154CFE95B0E9E4892F8E62");
        startActivityForResult(tokenIntent, MonetaryTokenizerActivity.MONETARY_TOKENIZER_REQUEST);
    }

}
