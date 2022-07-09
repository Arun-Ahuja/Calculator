package com.example.arunahuja.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCe, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero, btnDot, btnAc, btnTan, btnSin, btnCos, btnMulty, btnDivid, btnSub, btnAdd, btnEqual;
    TextView tvDisplay, tvCalculation;
    boolean isClear = false;
    String tanValue;
    String btnTanText;
    boolean isCalculated=false;

    String cosValue;
    String sinValue;
    Calculator calculator;
    private static final String KEY_TEXT_VALUE = "textValue";
    private static final String KEY_ANOTHER_VALUE = "anothertextValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            CharSequence savedText = savedInstanceState.getCharSequence(KEY_TEXT_VALUE);
            tvDisplay.setText(savedText);
            CharSequence anotherSavedText = savedInstanceState.getCharSequence(KEY_ANOTHER_VALUE);

            tvCalculation.setText(anotherSavedText);
        }
        tvDisplay = findViewById(R.id.tvDisplay);

        calculator = new Calculator();
        btnOne = findViewById(R.id.one);
        btnTwo = findViewById(R.id.two);
        btnThree = findViewById(R.id.three);
        btnFour = findViewById(R.id.four);
        btnFive = findViewById(R.id.five);
        btnCe = findViewById(R.id.ce);
        btnSix = findViewById(R.id.six);
        btnSeven = findViewById(R.id.seven);
        btnEight = findViewById(R.id.eight);
        btnNine = findViewById(R.id.nine);
        btnZero = findViewById(R.id.zero);
        btnDot = findViewById(R.id.dot);
        btnAc = findViewById(R.id.ac);
        btnTan = findViewById(R.id.tangent);
        btnCos = findViewById(R.id.cosine);
        btnSin = findViewById(R.id.sine);
        btnMulty = findViewById(R.id.multiply);
        btnDivid = findViewById(R.id.division);
        btnSub = findViewById(R.id.subtraction);
        btnAdd = findViewById(R.id.addition);
        btnEqual = findViewById(R.id.equal);
        tvCalculation = findViewById(R.id.tvCalculation);


        btnCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tvDisplay.getText().toString().isEmpty()) {
                    String a = tvDisplay.getText().toString().substring(0, tvDisplay.getText().toString().length() - 1);
                    tvDisplay.setText(a);
                }
            }
        });


        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tanValue = btnTan.getText().toString();
                tvDisplay.setText(tanValue);
                calculator.setOperator(tanValue.charAt(0));

            }
        });
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinValue = btnSin.getText().toString();
                tvDisplay.setText(sinValue);
                calculator.setOperator(sinValue.charAt(0));

            }
        });
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cosValue = btnCos.getText().toString();
                tvDisplay.setText(cosValue);
                calculator.setOperator(cosValue.charAt(0));

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tvDisplay.getText().toString().isEmpty() && !tvDisplay.getText().toString().equals("sin") && !tvDisplay.getText().toString().equals("Cos") && !tvDisplay.getText().toString().equals("Tan")) {
                    if (!tvDisplay.getText().toString().contains("sin") && !tvDisplay.getText().toString().contains("Cos") && !tvDisplay.getText().toString().contains("Tan")) {
                        System.out.println(tvDisplay.getText().toString().contains("sin") + "-------");
                        calculator.setSecondOperand(Double.parseDouble(tvDisplay.getText().toString()));
                        tvCalculation.append(calculator.getSecondOperand() + " = ");
                        tvDisplay.setText(Double.toString(calculator.calculation()));
                        isCalculated=true;
                    } else {
                        if (!tvCalculation.getText().toString().isEmpty()) {
                            tvCalculation.setText("");
                        }
                        String setSinValue = tvDisplay.getText().toString().substring(3);
                        System.out.println(setSinValue + "-------");


                        calculator.setFirstOperand(Double.parseDouble(setSinValue));
                        tvDisplay.setText(Double.toString(calculator.calculation()));


                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter valid input to calculate", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCalculated=false;
                tvDisplay.setText("");
                tvCalculation.setText("");
                calculator.setOperator('m');
                calculator.setFirstOperand(0);
                calculator.setSecondOperand(0);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(KEY_TEXT_VALUE, tvDisplay.getText());
        outState.putCharSequence(KEY_ANOTHER_VALUE, tvCalculation.getText());

    }


    public void btnDigitClick(View view) {

        if(isCalculated && (!tvDisplay.getText().toString().contains("+") && !tvDisplay.getText().toString().contains("-") && !tvDisplay.getText().toString().contains("*") && !tvDisplay.getText().toString().contains("/") && !tvDisplay.getText().toString().contains("sin") && !tvDisplay.getText().toString().contains("Cos") && !tvDisplay.getText().toString().contains("Tan"))){
           calculator.setFirstOperand(Double.parseDouble(tvDisplay.getText().toString()));
           tvDisplay.setText("");
        }


            if (isClear) {

                tvDisplay.setText("");
                isClear = false;
            }
            tvDisplay.append(((Button) view).getText().toString());

    }


    public void operatorBtnClick(View view) {
        isClear = true;

        if (!tvDisplay.getText().toString().isEmpty() && !tvDisplay.getText().toString().contains("Cos") &&
                !tvDisplay.getText().toString().contains("Tan") && !tvDisplay.getText().toString().contains("sin")) {
            if (tvDisplay.getText().toString() != "sin" || tvDisplay.getText().toString() != "Tan" || tvDisplay.getText().toString() != "Cos") {
                calculator.setFirstOperand(Double.parseDouble(tvDisplay.getText().toString()));
                calculator.setOperator(((Button) view).getText().toString().charAt(0));
                tvCalculation.setText(tvDisplay.getText().toString() + " " + calculator.getOperator() + " ");
            }
        }

    }


}
