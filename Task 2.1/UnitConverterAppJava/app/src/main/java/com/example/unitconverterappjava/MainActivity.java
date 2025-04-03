package com.example.unitconverterappjava;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner fromConvertSpinner;
    Spinner toConvertSpinner;
    EditText toConvert;
    Button convertButton;
    TextView conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding the the UI elements
        fromConvertSpinner = findViewById(R.id.fromConvertSpinner);
        toConvertSpinner = findViewById(R.id.toConvertSpinner);
        toConvert = findViewById(R.id.toConvert);
        conversion = findViewById(R.id.conversion);
        convertButton = findViewById(R.id.convertButton);

        // Array for spinner options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.unitTypes, // points to the array in strings.xml
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromConvertSpinner.setAdapter(adapter);
        toConvertSpinner.setAdapter(adapter);

        // Set up the conversion button listener
        convertButton.setOnClickListener(v -> convertUnits());
    }

    private void convertUnits() {

        //clears result when pressing the button
        conversion.setText("0");

        String fromUnit = fromConvertSpinner.getSelectedItem().toString();
        String toUnit = toConvertSpinner.getSelectedItem().toString();
        String inputText = toConvert.getText().toString();

        // Button will convert unless field is empty
        if (!inputText.isEmpty()) {
            double inputValue = Double.parseDouble(inputText);
            double convertedValue = convert(fromUnit, toUnit, inputValue);

            // Will display at bottom of page
            conversion.setText(String.format(Locale.getDefault(), "%.2f %s", convertedValue, toUnit));
        }
    }

    // All of the valid combinations are called by convertUnits() and return value
    // If combination is invalid it returns 0
    private double convert(String fromUnit, String toUnit, double value) {
        // All length conversion options
        if (fromUnit.equals("Centimetre") && toUnit.equals("Kilometre")) {
            return value / 100000;
        }
        if (fromUnit.equals("Centimetre") && toUnit.equals("Inch")) {
            return value / 2.54;
        }
        if (fromUnit.equals("Centimetre") && toUnit.equals("Foot")) {
            return value / 30.48;
        }
        if (fromUnit.equals("Centimetre") && toUnit.equals("Yard")) {
            return value / 91.44;
        }
        if (fromUnit.equals("Centimetre") && toUnit.equals("Mile")) {
            return value / 160934;
        }

        if (fromUnit.equals("Kilometre") && toUnit.equals("Centimetre")) {
            return value * 100000;
        }
        if (fromUnit.equals("Kilometre") && toUnit.equals("Inch")) {
            return value * 39370.1;
        }
        if (fromUnit.equals("Kilometre") && toUnit.equals("Foot")) {
            return value * 3280.84;
        }
        if (fromUnit.equals("Kilometre") && toUnit.equals("Yard")) {
            return value * 1093.61;
        }
        if (fromUnit.equals("Kilometre") && toUnit.equals("Mile")) {
            return value / 1.60934;
        }

        if (fromUnit.equals("Inch") && toUnit.equals("Centimetre")) {
            return value * 2.54;
        }
        if (fromUnit.equals("Inch") && toUnit.equals("Kilometre")) {
            return value / 39370.1;
        }
        if (fromUnit.equals("Inch") && toUnit.equals("Foot")) {
            return value / 12;
        }
        if (fromUnit.equals("Inch") && toUnit.equals("Yard")) {
            return value / 36;
        }
        if (fromUnit.equals("Inch") && toUnit.equals("Mile")) {
            return value / 63360;
        }

        if (fromUnit.equals("Foot") && toUnit.equals("Centimetre")) {
            return value * 30.48;
        }
        if (fromUnit.equals("Foot") && toUnit.equals("Kilometre")) {
            return value / 3280.84;
        }
        if (fromUnit.equals("Foot") && toUnit.equals("Inch")) {
            return value * 12;
        }
        if (fromUnit.equals("Foot") && toUnit.equals("Yard")) {
            return value / 3;
        }
        if (fromUnit.equals("Foot") && toUnit.equals("Mile")) {
            return value / 5280;
        }

        if (fromUnit.equals("Yard") && toUnit.equals("Centimetre")) {
            return value * 91.44;
        }
        if (fromUnit.equals("Yard") && toUnit.equals("Kilometre")) {
            return value / 1093.61;
        }
        if (fromUnit.equals("Yard") && toUnit.equals("Inch")) {
            return value * 36;
        }
        if (fromUnit.equals("Yard") && toUnit.equals("Foot")) {
            return value * 3;
        }
        if (fromUnit.equals("Yard") && toUnit.equals("Mile")) {
            return value / 1760;
        }

        if (fromUnit.equals("Mile") && toUnit.equals("Centimetre")) {
            return value * 160934;
        }
        if (fromUnit.equals("Mile") && toUnit.equals("Kilometre")) {
            return value * 1.60934;
        }
        if (fromUnit.equals("Mile") && toUnit.equals("Inch")) {
            return value * 63360;
        }
        if (fromUnit.equals("Mile") && toUnit.equals("Foot")) {
            return value * 5280;
        }
        if (fromUnit.equals("Mile") && toUnit.equals("Yard")) {
            return value * 1760;
        }

        // All weight conversion options
        if (fromUnit.equals("Pound") && toUnit.equals("Kilogram")) {
            return value * 0.453592;
        }
        if (fromUnit.equals("Pound") && toUnit.equals("Ounce")) {
            return value * 16;
        }
        if (fromUnit.equals("Pound") && toUnit.equals("Ton")) {
            return value / 2000;
        }
        if (fromUnit.equals("Pound") && toUnit.equals("Gram")) {
            return value * 453.592;
        }

        if (fromUnit.equals("Ounce") && toUnit.equals("Pound")) {
            return value / 16;
        }
        if (fromUnit.equals("Ounce") && toUnit.equals("Kilogram")) {
            return value * 0.0283495;
        }
        if (fromUnit.equals("Ounce") && toUnit.equals("Ton")) {
            return value / 32000;
        }
        if (fromUnit.equals("Ounce") && toUnit.equals("Gram")) {
            return value * 28.3495;
        }

        if (fromUnit.equals("Ton") && toUnit.equals("Pound")) {
            return value * 2000;
        }
        if (fromUnit.equals("Ton") && toUnit.equals("Ounce")) {
            return value * 32000;
        }
        if (fromUnit.equals("Ton") && toUnit.equals("Kilogram")) {
            return value * 907.185;
        }
        if (fromUnit.equals("Ton") && toUnit.equals("Gram")) {
            return value * 907185;
        }

        if (fromUnit.equals("Gram") && toUnit.equals("Pound")) {
            return value / 453.592;
        }
        if (fromUnit.equals("Gram") && toUnit.equals("Ounce")) {
            return value / 28.3495;
        }
        if (fromUnit.equals("Gram") && toUnit.equals("Ton")) {
            return value / 907185;
        }
        if (fromUnit.equals("Gram") && toUnit.equals("Kilogram")) {
            return value / 1000;
        }

        if (fromUnit.equals("Kilogram") && toUnit.equals("Pound")) {
            return value / 0.453592;
        }
        if (fromUnit.equals("Kilogram") && toUnit.equals("Ounce")) {
            return value * 35.274;
        }
        if (fromUnit.equals("Kilogram") && toUnit.equals("Ton")) {
            return value / 1000;
        }
        if (fromUnit.equals("Kilogram") && toUnit.equals("Gram")) {
            return value * 1000;
        }

        // All temp conversion options
        if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
            return (value * 1.8) + 32;
        }
        if (fromUnit.equals("Celsius") && toUnit.equals("Kelvin")) {
            return value + 273.15;
        }

        if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
            return (value - 32) / 1.8;
        }
        if (fromUnit.equals("Fahrenheit") && toUnit.equals("Kelvin")) {
            return (value - 32) / 1.8 + 273.15;
        }

        if (fromUnit.equals("Kelvin") && toUnit.equals("Celsius")) {
            return value - 273.15;
        }
        if (fromUnit.equals("Kelvin") && toUnit.equals("Fahrenheit")) {
            return (value - 273.15) * 1.8 + 32;
        }
        else return 0;
    }
}