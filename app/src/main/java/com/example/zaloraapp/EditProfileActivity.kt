package com.example.zaloraapp;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class EditProfileActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etEmail, etPhone, etBirthday;
    private RadioGroup rgGender;
    private Button btnSaveProfile;
    private TextView tvCancel, tvChangePhoto;

    // SharedPreferences file name — must be the same string in every Activity that uses it
    public static final String PREFS_NAME = "UserProfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        etFirstName    = findViewById(R.id.etFirstName);
        etLastName     = findViewById(R.id.etLastName);
        etEmail        = findViewById(R.id.etEmail);
        etPhone        = findViewById(R.id.etPhone);
        etBirthday     = findViewById(R.id.etBirthday);
        rgGender       = findViewById(R.id.rgGender);
        btnSaveProfile = findViewById(R.id.btnSaveProfile);
        tvCancel       = findViewById(R.id.tvCancel);
        tvChangePhoto  = findViewById(R.id.tvChangePhoto);

        // Load existing saved data and pre-fill the fields
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        etFirstName.setText(prefs.getString("firstName", ""));
        etLastName.setText(prefs.getString("lastName", ""));
        etEmail.setText(prefs.getString("email", ""));
        etPhone.setText(prefs.getString("phone", ""));
        etBirthday.setText(prefs.getString("birthday", ""));

        // Pre-select gender radio button
        String savedGender = prefs.getString("gender", "");
        if (savedGender.equals("Male"))   ((RadioButton) findViewById(R.id.rbMale)).setChecked(true);
        if (savedGender.equals("Female")) ((RadioButton) findViewById(R.id.rbFemale)).setChecked(true);
        if (savedGender.equals("Other"))  ((RadioButton) findViewById(R.id.rbOther)).setChecked(true);

        // Birthday picker
        etBirthday.setOnClickListener(v -> {
            Calendar cal = Calendar.getInstance();
            int year  = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day   = cal.get(Calendar.DAY_OF_MONTH);

            new DatePickerDialog(this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        String date = String.format("%02d/%02d/%04d",
                                selectedMonth + 1, selectedDay, selectedYear);
                        etBirthday.setText(date);
                    }, year, month, day).show();
        });

        // Change photo
        tvChangePhoto.setOnClickListener(v -> {
            Toast.makeText(this, "Change photo coming soon", Toast.LENGTH_SHORT).show();
        });

        // Save Changes — write to SharedPreferences then go back
        btnSaveProfile.setOnClickListener(v -> {
            String firstName = etFirstName.getText().toString().trim();
            String lastName  = etLastName.getText().toString().trim();
            String email     = etEmail.getText().toString().trim();
            String phone     = etPhone.getText().toString().trim();
            String birthday  = etBirthday.getText().toString().trim();

            // Validation
            if (TextUtils.isEmpty(firstName)) {
                etFirstName.setError("First name is required");
                return;
            }
            if (TextUtils.isEmpty(lastName)) {
                etLastName.setError("Last name is required");
                return;
            }
            if (TextUtils.isEmpty(email)) {
                etEmail.setError("Email is required");
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Enter a valid email address");
                return;
            }

            // Get selected gender
            String gender = "";
            int selectedId = rgGender.getCheckedRadioButtonId();
            if (selectedId != -1) {
                gender = ((RadioButton) findViewById(selectedId)).getText().toString();
            }

            // Save everything to SharedPreferences
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            editor.putString("firstName", firstName);
            editor.putString("lastName",  lastName);
            editor.putString("email",     email);
            editor.putString("phone",     phone);
            editor.putString("birthday",  birthday);
            editor.putString("gender",    gender);
            editor.apply();

            Toast.makeText(this, "Profile updated!", Toast.LENGTH_SHORT).show();
            finish(); // go back to ProfileActivity
        });

        // Cancel
        tvCancel.setOnClickListener(v -> finish());
    }
}