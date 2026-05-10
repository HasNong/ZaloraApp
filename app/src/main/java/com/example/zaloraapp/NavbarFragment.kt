package com.example.zaloraapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class NavbarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_navbar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<LinearLayout>(R.id.nav_shop).setOnClickListener {
            val intent = Intent(requireContext(), DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
        }

        view.findViewById<LinearLayout>(R.id.nav_discover).setOnClickListener {
            val intent = Intent(requireContext(), ProductListingActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
        }

        view.findViewById<LinearLayout>(R.id.nav_feed).setOnClickListener {
            // Feed activity - placeholder or same as listing for now
            val intent = Intent(requireContext(), ProductListingActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
        }

        view.findViewById<LinearLayout>(R.id.nav_bag).setOnClickListener {
            val intent = Intent(requireContext(), BagActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
        }

        view.findViewById<LinearLayout>(R.id.nav_account).setOnClickListener {
            val intent = Intent(requireContext(), AccountActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
        }
    }
}