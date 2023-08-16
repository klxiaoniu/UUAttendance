package com.uu.attendance.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.uu.attendance.databinding.FragmentMeBinding
import com.uu.attendance.ui.activity.LoginActivity
import com.uu.attendance.ui.activity.RulesActivity
import com.uu.attendance.ui.activity.SuperviseDetailActivity


class MeFragment : BaseFragment<FragmentMeBinding>() {

    companion object {
        val instance: MeFragment by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            MeFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivAvatar.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }

        binding.itemRule.setOnClickListener {
            val intent = Intent(requireContext(), RulesActivity::class.java)
            startActivity(intent)
        }

        binding.itemExit.setOnClickListener {
            val intent = Intent(requireContext(), SuperviseDetailActivity::class.java)
            startActivity(intent)
        }
    }


}