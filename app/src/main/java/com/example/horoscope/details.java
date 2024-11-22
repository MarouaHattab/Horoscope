package com.example.horoscope;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView signImageView = findViewById(R.id.signImageView);
        TextView signNameTextView = findViewById(R.id.signNameTextView);
        TextView signDescriptionTextView = findViewById(R.id.signDescriptionTextView);

        // Get the zodiac sign name passed from MainActivity
        String sign = getIntent().getStringExtra("sign");

        if (sign != null) {
            switch (sign) {
                case "Aquarius":
                    signImageView.setImageResource(R.drawable.aquarius);
                    signNameTextView.setText("Aquarius (January 20 - February 18)");
                    signDescriptionTextView.setText("Aquarius is known for their independent and innovative spirit. They are thinkers and love intellectual stimulation.");
                    break;
                case "Pisces":
                    signImageView.setImageResource(R.drawable.pisces);
                    signNameTextView.setText("Pisces (February 19 - March 20)");
                    signDescriptionTextView.setText("Pisces are empathetic, creative, and deeply connected to their emotions. They have a natural artistic flair.");
                    break;
                case "Aries":
                    signImageView.setImageResource(R.drawable.aries);
                    signNameTextView.setText("Aries (March 21 - April 19)");
                    signDescriptionTextView.setText("Aries is bold, determined, and passionate. They are natural leaders who are always ready for a challenge.");
                    break;
                case "Taurus":
                    signImageView.setImageResource(R.drawable.taurus);
                    signNameTextView.setText("Taurus (April 20 - May 20)");
                    signDescriptionTextView.setText("Taurus is reliable, patient, and devoted. They love beauty and the finer things in life.");
                    break;
                case "Gemini":
                    signImageView.setImageResource(R.drawable.gemini);
                    signNameTextView.setText("Gemini (May 21 - June 20)");
                    signDescriptionTextView.setText("Gemini is curious, adaptable, and loves to communicate. They thrive on variety and learning new things.");
                    break;
                case "Cancer":
                    signImageView.setImageResource(R.drawable.cancer);
                    signNameTextView.setText("Cancer (June 21 - July 22)");
                    signDescriptionTextView.setText("Cancer is nurturing, intuitive, and deeply empathetic. They cherish their home and loved ones.");
                    break;
                case "Leo":
                    signImageView.setImageResource(R.drawable.leo);
                    signNameTextView.setText("Leo (July 23 - August 22)");
                    signDescriptionTextView.setText("Leo is confident, charismatic, and loves the spotlight. They are natural leaders who bring joy to others.");
                    break;
                case "Virgo":
                    signImageView.setImageResource(R.drawable.virgo);
                    signNameTextView.setText("Virgo (August 23 - September 22)");
                    signDescriptionTextView.setText("Virgo is practical, analytical, and detail-oriented. They are perfectionists who value hard work.");
                    break;
                case "Libra":
                    signImageView.setImageResource(R.drawable.libra);
                    signNameTextView.setText("Libra (September 23 - October 22)");
                    signDescriptionTextView.setText("Libra is diplomatic, charming, and loves harmony. They have a great sense of balance and fairness.");
                    break;
                case "Scorpio":
                    signImageView.setImageResource(R.drawable.scorpio);
                    signNameTextView.setText("Scorpio (October 23 - November 21)");
                    signDescriptionTextView.setText("Scorpio is passionate, resourceful, and determined. They are intense and deeply emotional.");
                    break;
                case "Sagittarius":
                    signImageView.setImageResource(R.drawable.sagittarius);
                    signNameTextView.setText("Sagittarius (November 22 - December 21)");
                    signDescriptionTextView.setText("Sagittarius is adventurous, optimistic, and loves to explore. They are seekers of knowledge and truth.");
                    break;
                case "Capricorn":
                    signImageView.setImageResource(R.drawable.capricorn);
                    signNameTextView.setText("Capricorn (December 22 - January 19)");
                    signDescriptionTextView.setText("Capricorn is disciplined, ambitious, and practical. They strive for success and value tradition.");
                    break;
                default:
                    signNameTextView.setText("Unknown Sign");
                    signDescriptionTextView.setText("No information available.");
                    break;
            }
        }

        // Ensure the text style and color for sign name is consistent
        signNameTextView.setTextColor(getResources().getColor(R.color.dark_blue)); // Ensure this matches #0C2436
    }
}
