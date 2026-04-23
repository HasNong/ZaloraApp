package com.example.zaloraapp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvFullName, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvFullName = findViewById(R.id.tvFullName);
        tvEmail    = findViewById(R.id.tvEmail);

        // Edit Profile
        LinearLayout rowEditProfile = findViewById(R.id.rowEditProfile);
        rowEditProfile.setOnClickListener(v ->
                startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class))
        );

        // My Orders
        LinearLayout rowMyOrders = findViewById(R.id.rowMyOrders);
        rowMyOrders.setOnClickListener(v ->
                Toast.makeText(this, "My Orders", Toast.LENGTH_SHORT).show()
        );

        // Wishlist
        LinearLayout rowWishlist = findViewById(R.id.rowWishlist);
        rowWishlist.setOnClickListener(v ->
                Toast.makeText(this, "My Wishlist", Toast.LENGTH_SHORT).show()
        );

        // Saved Addresses
        LinearLayout rowAddresses = findViewById(R.id.rowAddresses);
        rowAddresses.setOnClickListener(v ->
                Toast.makeText(this, "Saved Addresses", Toast.LENGTH_SHORT).show()
        );

        // Change Password
        LinearLayout rowChangePassword = findViewById(R.id.rowChangePassword);
        rowChangePassword.setOnClickListener(v ->
                startActivity(new Intent(ProfileActivity.this, ChangePasswordActivity.class))
        );

        // Logout
        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v ->
                new AlertDialog.Builder(this)
                        .setTitle("Log Out")
                        .setMessage("Are you sure you want to log out?")
                        .setPositiveButton("Log Out", (dialog, which) -> {
                            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        })
                        .setNegativeButton("Cancel", null)
                        .show()
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        // onResume runs every time this screen comes back into focus
        // (e.g. after returning from EditProfileActivity)
        // so the name and email will always be up to date
        loadProfile();
    }

    private void loadProfile() {
        SharedPreferences prefs = getSharedPreferences(EditProfileActivity.PREFS_NAME, MODE_PRIVATE);
        String firstName = prefs.getString("firstName", "");
        String lastName  = prefs.getString("lastName",  "");
        String email     = prefs.getString("email",     "");

        // Show full name — fallback to "My Profile" if nothing saved yet
        String fullName = (firstName + " " + lastName).trim();
        tvFullName.setText(fullName.isEmpty() ? "My Profile" : fullName);

        // Show email — fallback to empty
        tvEmail.setText(email);
    }
}