# Getting started with MobileToken for Android

###Add MonetaryMobileToken.aar to your Android (Gradle) project
1. Place MonetaryMobileToken.aar in the `libs` folder of your app.
2. Ensure `libs` folder is included in `flatDir` repositories in your app's build.gradle file.

    ```
    repositories {
      flatDir {
        dirs 'libs'
      }
    }
    ```

3. Add MonetaryMobileToken.aar to the `dependencies` in your app's build.gradle file.

    ```
    dependencies {
      compile (name: 'MonetaryMobileToken', ext: 'aar')
    }
    ```

###Include the library in your code
```java
import co.monetary.mobiletoken.*;
```

###Implement tokenization result handler
#####Implement `onActivityResult` for `MonetaryTokenizerActivity.MONETARY_TOKENIZER_REQUEST` requestCode
```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data)
{
    if (requestCode == MonetaryTokenizerActivity.MONETARY_TOKENIZER_REQUEST)
    {
        if (resultCode == MonetaryTokenizerActivity.RESULT_SUCCESS)
        {
            // A token has been received!
            MonetaryToken token = (MonetaryToken)data.getSerializableExtra("token");
        }
        else if (resultCode == MonetaryTokenizerActivity.RESULT_ERROR)
        {
            // A tokenization error has occurred!
            MonetaryTokenizationError error = (MonetaryTokenizationError)data.getSerializableExtra("error");
        }
        else if (resultCode == MonetaryTokenizerActivity.RESULT_CANCELED)
        {
            // The user has cancelled tokenization!
        }
    }
}
```

For the `MonetaryTokenizerActivity.RESULT_SUCCESS` resultCode, the received Intent contains a `MonetaryToken` object named `"token"` that contains 5 String members:  
* `token`: The one-time-use token for the user-entered account data.
* `brand`: The card brand of account represented by the token.
* `expirationMonth`: The 2-digit expiration month of the account.
* `expirationYear`: The 4-digit expiration year of the account.
* `last4`: The last 4 digits of the account number.

For the `MonetaryTokenizerActivity.RESULT_ERROR` resultCode, the received Intent contains a `MonetaryTokenizationError` object named `"error"` that contains 2 members:  
* `errorCode`: The MonetaryMobileToken error code.
* `errorMessage`: The error description.

The `MonetaryTokenizationError` object's member `errorCode` is an enum of 4 possible values:
* `ErrorCodes.CONNECTION_ERROR`: Failed to communicate with Monetary Token API.
* `ErrorCodes.AUTHENTICATION_ERROR`: Public key authentication failed.
* `ErrorCodes.VALIDATION_ERROR`: Failed to tokenize due to invalid account information.
* `ErrorCodes.UNKNOWN_ERROR`: An error has occurred tokenizing the account data at the Monetary Token API.

###Request a token for keyed account
#####Create an Intent for `MonetaryTokenizerActivity` and provide a Monetary public key as an extra named `"publicKey"` then start activity for result with the Intent
```java
Intent tokenIntent = new Intent(this, MonetaryTokenizerActivity.class);
tokenIntent.putExtra("publicKey", "[Public Key Goes Here]");
startActivityForResult(tokenIntent, MonetaryTokenizerActivity.MONETARY_TOKENIZER_REQUEST);
```

###Report bugs
If you encounter any bugs or issues with the latest version of MobileToken for Android, please report them to us by opening a [GitHub Issue](https://github.com/Mntry/MobileToken-Android/issues)!
