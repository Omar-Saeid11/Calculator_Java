package com.example.calculatorjava;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.example.calculatorjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        onClicks();
    }

    private void onClicks() {
        binding.zero.setOnClickListener(this);
        binding.one.setOnClickListener(this);
        binding.two.setOnClickListener(this);
        binding.three.setOnClickListener(this);
        binding.four.setOnClickListener(this);
        binding.five.setOnClickListener(this);
        binding.six.setOnClickListener(this);
        binding.seven.setOnClickListener(this);
        binding.eight.setOnClickListener(this);
        binding.nine.setOnClickListener(this);
        binding.restore.setOnClickListener(v -> binding.textResult.setText(""));
        binding.close.setOnClickListener(v -> finish());
        binding.ac.setOnClickListener(v -> clear());

        binding.plus.setOnClickListener(v -> handleOperation(binding.plus));
        binding.subtraction.setOnClickListener(v -> handleOperation(binding.subtraction));
        binding.multiply.setOnClickListener(v -> handleOperation(binding.multiply));
        binding.div.setOnClickListener(v -> handleOperation(binding.div));
        binding.ac.setOnLongClickListener(v -> {
            clear();
            return true;
        });
        binding.ac.setOnClickListener(v -> {
            String txt = binding.textResult.getText().toString();
            binding.textResult.setText(txt.substring(0, txt.length() - 1));
        });

        binding.equal.setOnClickListener(v -> {
            String res = getResText();

            if (res.contains("-")) {
                String[] txtRes = binding.textResult.getText().toString().split("-");
                if (txtRes.length == 2) {
                    setUpCalc(Double.parseDouble(txtRes[0]), '-', Double.parseDouble(txtRes[1]));
                }
            } else if (res.contains("+")) {
                String[] txtRes = binding.textResult.getText().toString().split("\\+");
                if (txtRes.length == 2) {
                    setUpCalc(Double.parseDouble(txtRes[0]), '+', Double.parseDouble(txtRes[1]));
                }
            } else if (res.contains("*")) {
                String[] txtRes = binding.textResult.getText().toString().split("\\*");
                if (txtRes.length == 2) {
                    setUpCalc(Double.parseDouble(txtRes[0]), '*', Double.parseDouble(txtRes[1]));
                }
            } else if (res.contains("/")) {
                String[] txtRes = binding.textResult.getText().toString().split("/");
                if (txtRes.length == 2) {
                    setUpCalc(Double.parseDouble(txtRes[0]), '/', Double.parseDouble(txtRes[1]));
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        AppCompatButton button = (AppCompatButton) v;
        binding.textResult.append(button.getText().toString());
    }

    private void handleOperation(AppCompatButton appCompatButton) {
        String txt = binding.textResult.getText().toString();
        if (!txt.isEmpty()) {
            char ch = txt.charAt(txt.length() - 1);
            if (ch != '+' && ch != '-' && ch != '*' && ch != '/') {
                binding.textResult.append(appCompatButton.getText().toString());
            }
        }
    }

    private String getResText() {
        return binding.textResult.getText().toString().trim();
    }

    private void clear() {
        binding.textResult.setText("");
    }

    private void setUpCalc(double num1, char op, double num2) {
        switch (op) {
            case '+': {
                binding.textResult.setText((num1 + num2 + ""));
            }
            break;
            case '-': {
                binding.textResult.setText((num1 - num2 + ""));
            }
            break;
            case '*': {
                binding.textResult.setText((num1 * num2 + ""));
            }
            break;
            case '/': {
                if (num2 == 0) {
                    binding.textResult.setText("Can't divide by zero");
                } else {
                    binding.textResult.setText((num1 / num2 + ""));
                }
            }
            break;
        }
    }

    public void setColorsAndBackgrounds(
            int mainScreenColor,
            int screenResultBackground,
            int textColor,
            int operationColor,
            int operationBackground,
            int numberColor,
            int numberBackground,
            int acColor,
            int acBackground
    ) {
        binding.mainScreen.setBackgroundColor(ContextCompat.getColor(this, mainScreenColor));
        binding.screenResult.setBackgroundResource(screenResultBackground);
        binding.textResult.setTextColor(ContextCompat.getColor(this, textColor));
        binding.plus.setTextColor(ContextCompat.getColor(this, operationColor));
        binding.plus.setBackgroundResource(operationBackground);
        binding.subtraction.setTextColor(ContextCompat.getColor(this, operationColor));
        binding.subtraction.setBackgroundResource(operationBackground);
        binding.multiply.setTextColor(ContextCompat.getColor(this, operationColor));
        binding.multiply.setBackgroundResource(operationBackground);
        binding.div.setTextColor(ContextCompat.getColor(this, operationColor));
        binding.div.setBackgroundResource(operationBackground);
        binding.equal.setTextColor(ContextCompat.getColor(this, operationColor));
        binding.equal.setBackgroundResource(operationBackground);
        binding.zero.setTextColor(ContextCompat.getColor(this, numberColor));
        binding.zero.setBackgroundResource(numberBackground);
        binding.one.setTextColor(ContextCompat.getColor(this, numberColor));
        binding.one.setBackgroundResource(numberBackground);
        binding.two.setTextColor(ContextCompat.getColor(this, numberColor));
        binding.two.setBackgroundResource(numberBackground);
        binding.three.setTextColor(ContextCompat.getColor(this, numberColor));
        binding.three.setBackgroundResource(numberBackground);
        binding.four.setTextColor(ContextCompat.getColor(this, numberColor));
        binding.four.setBackgroundResource(numberBackground);
        binding.five.setTextColor(ContextCompat.getColor(this, numberColor));
        binding.five.setBackgroundResource(numberBackground);
        binding.six.setTextColor(ContextCompat.getColor(this, numberColor));
        binding.six.setBackgroundResource(numberBackground);
        binding.seven.setTextColor(ContextCompat.getColor(this, numberColor));
        binding.seven.setBackgroundResource(numberBackground);
        binding.eight.setTextColor(ContextCompat.getColor(this, numberColor));
        binding.eight.setBackgroundResource(numberBackground);
        binding.nine.setTextColor(ContextCompat.getColor(this, numberColor));
        binding.nine.setBackgroundResource(numberBackground);
        binding.dot.setTextColor(ContextCompat.getColor(this, numberColor));
        binding.dot.setBackgroundResource(numberBackground);
        binding.ac.setTextColor(ContextCompat.getColor(this, acColor));
        binding.ac.setBackgroundResource(acBackground);
    }

    public void lightMode(View view) {
        setColorsAndBackgrounds(
                R.color.white,
                R.drawable.background_screen_show_light,
                androidx.appcompat.R.color.primary_material_dark,
                R.color.outlineScreenShowColor,
                R.drawable.button_plus_and_equal_light,
                R.color.PrimarybackgroundColor,
                R.drawable.button_plus_and_equal_light,
                R.color.outlineScreenShowColor,
                R.drawable.button_light_mode);
    }

    public void dark(View view) {
        setColorsAndBackgrounds(
                R.color.PrimarybackgroundColor,
                R.drawable.background_screen_show,
                R.color.outlineScreenShowColor,
                R.color.outlineScreenShowColor,
                R.drawable.button_plus_and_equal_dark,
                R.color.outlineScreenShowColor,
                R.drawable.background_buttons_dark,
                R.color.outlineScreenShowColor,
                R.drawable.background_buttons_dark);
    }


}