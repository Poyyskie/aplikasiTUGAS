package com.example.rentallaptop.main_ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.rentallaptop.About
import com.example.rentallaptop.Profile
import com.example.rentallaptop.SignInActivity
import com.example.rentallaptop.Topup
import com.example.rentallaptop.databinding.FragmentAccountBinding
import com.example.rentallaptop.viewmodel.Editprofilee
import org.koin.android.ext.android.inject


class AccountFragment : Fragment() {
    private val viewModel: AccountViewModel by inject()
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
      ): View {

        _binding = FragmentAccountBinding.inflate(inflater, container, false)

        viewModel.getDataUser()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.about.setOnClickListener {
            startActivity(Intent(requireActivity(), About::class.java))}
        binding.Profile.setOnClickListener{
            startActivity(Intent(requireActivity(), Profile::class.java))}
        binding.tvSettings.setOnClickListener{
            startActivity(Intent(requireActivity(), Editprofilee::class.java))
        }

        viewModel.logout.observe(requireActivity(), { isLogout ->
            if (isLogout) {

                Toast.makeText(requireContext(), "Logout berhasil!", Toast.LENGTH_SHORT).show()

                startActivity(
                    Intent(requireActivity(), SignInActivity::class.java)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                )
            }
        })

        viewModel.user.observe(requireActivity(), { user ->
            with(binding){
                tvName.text = user.name
                tvNumberPhone.text = user.phoneNumber
                tvSaldo.text = "Rp.${user.saldo}"
            }
        })

        setupListener()
    }

    private fun setupListener() {
        with(binding){
            tvLogout.setOnClickListener {
                viewModel.logout()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}