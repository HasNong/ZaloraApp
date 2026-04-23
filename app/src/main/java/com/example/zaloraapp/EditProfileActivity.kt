package com.example.zaloraapp

import android.app.DatePickerDialog
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class EditProfileActivity : AppCompatActivity() {

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etBirthday: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var btnSaveProfile: Button
    private lateinit var tvCancel: TextView
    private lateinit var tvChangePhoto: TextView

    companion object {
        const val PREFS_NAME = "UserProfile"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        etFirstName    = findViewById(R.id.etFirstName)
        etLastName     = findViewById(R.id.etLastName)
        etEmail        = findViewById(R.id.etEmail)
        etPhone        = findViewById(R.id.etPhone)
        etBirthday     = findViewById(R.id.etBirthday)
        rgGender       = findViewById(R.id.rgGender)
        btnSaveProfile = findViewById(R.id.btnSaveProfile)
        tvCancel       = findViewById(R.id.tvCancel)
        tvChangePhoto  = findViewById(R.id.tvChangePhoto)

        // Load saved data
        val prefs: SharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        etFirstName.setText(prefs.getString("firstName", ""))
        etLastName.setText(prefs.getString("lastName", ""))
        etEmail.setText(prefs.getString("email", ""))
        etPhone.setText(prefs.getString("phone", ""))
        etBirthday.setText(prefs.getString("birthday", ""))

        when (prefs.getString("gender", "")) {
            "Male"   -> findViewById<RadioButton>(R.id.rbMale).isChecked   = true
            "Female" -> findViewById<RadioButton>(R.id.rbFemale).isChecked = true
            "Other"  -> findViewById<RadioButton>(R.id.rbOther).isChecked  = true
        }

        // Birthday date picker
        etBirthday.setOnClickListener {
            val cal   = Calendar.getInstance()
            val year  = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day   = cal.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                    val date = String.format("%02d/%02d/%04d", selectedMonth + 1, selectedDay, selectedYear)
                    etBirthday.setText(date)
            }, year, month, day).show()
        }

        tvChangePhoto.setOnClickListener {
            Toast.makeText(this, "Change photo coming soon", Toast.LENGTH_SHORT).show()
        }

        btnSaveProfile.setOnClickListener {
            val firstName = etFirstName.text.toString().trim()
            val lastName  = etLastName.text.toString().trim()
            val email     = etEmail.text.toString().trim()
            val phone     = etPhone.text.toString().trim()
            val birthday  = etBirthday.text.toString().trim()

            if (TextUtils.isEmpty(firstName)) {
                etFirstName.error = "First name is required"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(lastName)) {
                etLastName.error = "Last name is required"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(email)) {
                etEmail.error = "Email is required"
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Enter a valid email address"
                return@setOnClickListener
            }

            val gender = rgGender.checkedRadioButtonId
                    .takeIf { it != -1 }
                ?.let { findViewById<RadioButton>(it).text.toString() }
                ?: ""

            getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit().apply {
                putString("firstName", firstName)
                putString("lastName",  lastName)
                putString("email",     email)
                putString("phone",     phone)
                putString("birthday",  birthday)
                putString("gender",    gender)
                apply()
            }

            Toast.makeText(this, "Profile updated!", Toast.LENGTH_SHORT).show()
            finish()
        }

        tvCancel.setOnClickListener { finish() }
    }
}