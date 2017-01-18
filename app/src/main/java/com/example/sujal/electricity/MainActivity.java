package com.example.sujal.electricity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText previous;
    EditText current;
    RadioGroup radio;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;
    RadioButton radioval;
    CheckBox payment;
    Button calculate;
   String radiovalue;
    TextView result;
    int value;
    float calculatevalue,amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        previous=(EditText)findViewById(R.id.edit1);
        current=(EditText)findViewById(R.id.edit2);
        radio=(RadioGroup)findViewById(R.id.radio);
        radio1=(RadioButton)findViewById(R.id.radioone);
        radio2=(RadioButton)findViewById(R.id.radiotwo);
        radio3=(RadioButton)findViewById(R.id.radiothree);
        radio4=(RadioButton)findViewById(R.id.radiofour);
        payment=(CheckBox)findViewById(R.id.payment);
        calculate=(Button)findViewById(R.id.calculate);
        result=(TextView)findViewById(R.id.result);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioval = (RadioButton) findViewById(checkedId);
                radiovalue = radioval.getText().toString();
                if (radiovalue.matches("5 A")) {
                    value = 5;
                } else if (radiovalue.matches("15 A")) {
                    value = 15;
                } else if (radiovalue.matches("30 A")) {
                    value = 30;
                } else if(radiovalue.matches("60 A"))
                {
                    value = 60;
                }
            }

        });
    }
    public void btnClick(View v) {
        String a = previous.getText().toString();
        String b = current.getText().toString();

        if (a.isEmpty() || b.isEmpty() || value == 0) {
            Toast.makeText(getApplication(), "Please enter both previous and current readings and ampere.", Toast.LENGTH_SHORT).show();
        } else {
            int first = Integer.parseInt(a);
            int second = Integer.parseInt(b);
            calculatevalue = first - second;
            if (value == 5) {
                if (calculatevalue <= 20) {
                    amount = 80;
                    if (payment.isChecked()) {
                        amount = (float) (amount - (amount * 0.02));
                        result.setText("Rs." + amount);
                    } else {
                        result.setText("Rs." + amount);
                    }
                } else if (calculatevalue > 20 && calculatevalue <= 31) {
                    amount = (float) ((20 * 4) + (calculatevalue - 20) * 7.3);
                    if (payment.isChecked()) {
                        amount = (float) (amount - (amount * 0.02));
                        result.setText("Rs." + amount);
                    } else {
                        result.setText("Rs." + amount);
                    }
                } else if (calculatevalue > 31 && calculatevalue <= 50) {
                    amount = (float) (calculatevalue * 7.3);
                    if (payment.isChecked()) {
                        amount = (float) (amount - (amount * 0.02));
                        result.setText("Rs." + amount);
                    } else {
                        result.setText("Rs." + amount);
                    }
                } else if ((calculatevalue > 50) && (calculatevalue <= 150)) {
                    amount = (float) ((50 * 7.30) + (calculatevalue - 50) * 8.60);
                    if (payment.isChecked()) {
                        amount = (float) (amount - (0.03 * amount));
                        result.setText("Rs " + amount);
                    } else {
                        result.setText("Rs " + amount);
                    }
                } else if ((calculatevalue > 150) && (calculatevalue <= 250)) {
                    amount = (float) ((150 * 8.60) + (calculatevalue - 150) * 9.50);
                    if (payment.isChecked()) {
                        amount = (float) (amount - (0.03 * amount));
                        result.setText("Rs " + amount);
                    } else {
                        result.setText("Rs " + amount);
                    }
                } else {
                    amount = (float) ((250 * 9.50) + (calculatevalue - 250) * 11);
                    if (payment.isChecked()) {
                        amount = (float) (amount - (0.03 * amount));
                        result.setText("Rs " + amount);
                    } else {
                        result.setText("Rs " + amount);
                    }
                }
            } else if (value == 15) {
                if (calculatevalue <= 50) {
                    amount = 365;
                    if (payment.isChecked()) {
                        amount = (float) (amount + (amount * 0.03));
                        result.setText("Rs." + amount);
                    }
                    result.setText("Rs." + amount);
                } else if (calculatevalue > 50 && calculatevalue <= 150) {
                    amount = (float) ((50 * 7.3) + ((calculatevalue - 50) * 8.6));
                    if (payment.isChecked()) {
                        result.setText("Rs." + amount);
                    } else {
                        result.setText("Rs." + amount);
                    }
                }
                else if((calculatevalue >150) && (calculatevalue<=250))
                {
                    amount = (float) ((150*8.60) + (calculatevalue-150) * 9.50);
                    if(payment.isChecked())
                    {
                        amount= (float) ( amount - (0.03 * amount));
                        result.setText("Rs " + amount);
                    }
                    else
                    {
                        result.setText("Rs " + amount);
                    }
                }
                else
                {
                    amount= (float) ((250 * 9.50) + (calculatevalue-250) * 11);
                    if(payment.isChecked())
                    {
                        amount= (float) ( amount - (0.03 *  amount));
                        result.setText("Rs " + amount);
                    }
                    else
                    {
                        result.setText("Rs " + amount);
                    }
                }
            }
            else if(value == 30)
            {
                if (calculatevalue <= 100) {
                    amount = 795;
                    if(payment.isChecked())
                    {
                        amount = (float) ( amount - (0.03 * amount));
                        result.setText("Rs " + amount);
                    }
                    else
                    {
                        result.setText("Rs " + amount);
                    }
                }
                else if((calculatevalue>100) && (calculatevalue <=150))
                {
                    amount = (float) ((50* 7.30) + (calculatevalue-50) * 8.60);
                    if(payment.isChecked())
                    {
                        amount = (float) ( amount - (0.03 *  amount));
                        result.setText("Rs " + amount);
                    }
                    else
                    {
                        result.setText("Rs " + amount);
                    }
                }
                else if((calculatevalue >150) && (calculatevalue <=250))
                {
                    amount = (float) ((150*8.60) + (calculatevalue-150) * 9.50);
                    if(payment.isChecked())
                    {
                        amount = (float) ( amount - (0.03 *  amount));
                        result.setText("Rs " + amount);
                    }
                    else
                    {
                        result.setText("Rs " + amount);
                    }
                }
                else
                {
                    amount = (float) ((250 * 9.50) + (calculatevalue-250) * 11);
                    if(payment.isChecked())
                    {
                        amount = (float) ( amount- (0.03 *  amount));
                        result.setText("Rs " + amount);
                    }
                    else
                    {
                        result.setText("Rs " + amount);
                    }
                }
            }
            else
            {
                if (calculatevalue <= 200) {
                    amount = 1765;
                    if(payment.isChecked())
                    {
                        amount = (float) ( amount - (0.03 * amount));
                        result.setText("Rs " + amount);
                    }
                    else
                    {
                        result.setText("Rs " + amount);
                    }
                }
                else if((calculatevalue>150) && (calculatevalue <=250))
                {
                    amount = (float) ((150 *8.60) + (calculatevalue-150) * 9.50);
                    if(payment.isChecked())
                    {
                        amount = (float) ( amount - (0.03 *  amount));
                        result.setText("Rs " + amount);
                    }
                    else{
                        result.setText("Rs " + amount);
                    }
                }
                else
                {
                    amount = (float) ((250 * 9.50) + (calculatevalue-250) * 11);
                    if(payment.isChecked())
                    {
                        amount = (float) ( amount - (0.03 * amount));
                        result.setText("Rs " + amount);
                    }
                    else
                    {
                        result.setText("Rs " + amount);
                    }
                }
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
