package com.example.horoscope;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner monthSpinner;
    private Spinner daySpinner;
    private Button findSignButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthSpinner = findViewById(R.id.monthSpinner);
        daySpinner = findViewById(R.id.daySpinner);
        findSignButton = findViewById(R.id.findSignButton);

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this,
                R.layout.spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        ArrayAdapter<String> dayAdapter = new ArrayAdapter<>(this,
                R.layout.spinner_item, days);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);

        monthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int month = position + 1;
                updateDaysForMonth(month);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        findSignButton.setOnClickListener(v -> {
            int month = monthSpinner.getSelectedItemPosition() + 1;
            int day = Integer.parseInt(daySpinner.getSelectedItem().toString());

            String zodiacSign = calculateZodiacSign(month, day);

            Intent intent = new Intent(MainActivity.this, details.class);
            intent.putExtra("sign", zodiacSign);
            startActivity(intent);
        });

    }
    private String calculateZodiacSign(int month, int day) {
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
            return "Aquarius";
        } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
            return "Pisces";
        } else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
            return "Aries";
        } else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
            return "Taurus";
        } else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) {
            return "Gemini";
        } else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) {
            return "Cancer";
        } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
            return "Leo";
        } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
            return "Virgo";
        } else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
            return "Libra";
        } else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) {
            return "Scorpio";
        } else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) {
            return "Sagittarius";
        } else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
            return "Capricorn";
        }
        return "Unknown";
    }

    private void updateDaysForMonth(int month) {
        int daysInMonth;

        switch (month) {
            case 1: // January
            case 3: // March
            case 5: // May
            case 7: // July
            case 8: // August
            case 10: // October
            case 12: // December
                daysInMonth = 31;
                break;
            case 2: // February
                daysInMonth = 28;  // February
                break;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                daysInMonth = 30;
                break;
            default:
                daysInMonth = 31;
                break;
        }

        String[] days = new String[daysInMonth];
        for (int i = 0; i < daysInMonth; i++) {
            days[i] = String.valueOf(i + 1);
        }

        ArrayAdapter<String> dayAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, days);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);
    }
}
