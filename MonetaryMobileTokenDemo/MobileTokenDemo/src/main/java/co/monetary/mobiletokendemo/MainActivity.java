package co.monetary.mobiletokendemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    enum AccountEntryStates
    {
        CARDNUMBER_ENTRY,
        EXPIRATION_ENTRY,
        CVV_ENTRY
    }

    TextView _tvAccountDisplay;
    AccountEntryStates _currentAccountEntryState;
    String _cardNumber, _expiration, _cvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _cardNumber = "";
        _expiration = "";
        _cvv = "";
        setContentView(R.layout.activity_main);
        _tvAccountDisplay = (TextView)findViewById(R.id.tvAccountDisplay);
        _currentAccountEntryState = AccountEntryStates.CARDNUMBER_ENTRY;
    }

    public void onButtonPress(View v)
    {
        switch (v.getId())
        {
            case R.id.btn0:
            {
                handleDigitPress('0');
                break;
            }
            case R.id.btn1:
            {
                handleDigitPress('1');
                break;
            }
            case R.id.btn2:
            {
                handleDigitPress('2');
                break;
            }
            case R.id.btn3:
            {
                handleDigitPress('3');
                break;
            }
            case R.id.btn4:
            {
                handleDigitPress('4');
                break;
            }
            case R.id.btn5:
            {
                handleDigitPress('5');
                break;
            }
            case R.id.btn6:
            {
                handleDigitPress('6');
                break;
            }
            case R.id.btn7:
            {
                handleDigitPress('7');
                break;
            }
            case R.id.btn8:
            {
                handleDigitPress('8');
                break;
            }
            case R.id.btn9:
            {
                handleDigitPress('9');
                break;
            }
            case R.id.btnNext:
            {
                handleNextPress();
                break;
            }
            case R.id.btnBack:
            {
                handleBackspacePress();
                break;
            }
        }

    }

    /***
     * Handle digit press by current state
     * @param digit Digit which to append to current data entry element
     */
    private void handleDigitPress(char digit)
    {
        switch (_currentAccountEntryState)
        {
            case CARDNUMBER_ENTRY:
            {
                appendToCardNumber(digit);
                break;
            }
            case EXPIRATION_ENTRY:
            {
                appendToExpiration(digit);
                break;
            }
            case CVV_ENTRY:
            {
                appendToCVV(digit);
                break;
            }
        }
    }

    /***
     * Handle backspace press by current state
     */
    private void handleBackspacePress()
    {
        switch (_currentAccountEntryState)
        {
            case CARDNUMBER_ENTRY:
            {
                backspaceCardNumber();
                break;
            }
            case EXPIRATION_ENTRY:
            {
                backspaceExpiration();
                break;
            }
            case CVV_ENTRY:
            {
                backspaceCVV();
                break;
            }
        }
    }

    /***
     * Handle 'Next' button press by current state
     */
    private void handleNextPress()
    {
        switch (_currentAccountEntryState)
        {
            case CARDNUMBER_ENTRY:
            {
                enterModeForState(AccountEntryStates.EXPIRATION_ENTRY);
                break;
            }
            case EXPIRATION_ENTRY:
            {
                enterModeForState(AccountEntryStates.CVV_ENTRY);
                break;
            }
            case CVV_ENTRY:
            {
                // DO WORK SON!
                break;
            }
        }
    }

    /***
     * Append provided digit to Card Number
     * @param digit Digit which to append to Card Number
     */
    private void appendToCardNumber(char digit)
    {
        if (_cardNumber.length() < 19)
        {
            // Append next character to Card Number
            _cardNumber += digit;
        }
        displayCardNumber();
    }

    /***
     * Remove last digit from Card Number
     */
    private void backspaceCardNumber()
    {
        if ((_cardNumber != null) && (!_cardNumber.isEmpty()))
        {
            // Remove last character in Card Number
            _cardNumber = _cardNumber.substring(0, _cardNumber.length()-1);
        }
        displayCardNumber();
    }


    /***
     * Display masked and formatted Card Number
     */
    private void displayCardNumber()
    {
        _tvAccountDisplay.setText(_cardNumber);
    }

    private void validateCardNumber()
    {

    }

    private void acceptCardNumber()
    {

    }

    private void appendToExpiration(char number)
    {

    }

    private void backspaceExpiration()
    {

    }

    private void displayExpiration()
    {

    }

    private void validateExpiration()
    {

    }

    private void acceptExpiration()
    {

    }

    private void appendToCVV(char number)
    {

    }

    private void backspaceCVV()
    {

    }

    private void displayCVV()
    {

    }

    private void validateCVV()
    {

    }

    private void acceptCVV()
    {

    }

    private void enterModeForState(AccountEntryStates state)
    {

    }


}
