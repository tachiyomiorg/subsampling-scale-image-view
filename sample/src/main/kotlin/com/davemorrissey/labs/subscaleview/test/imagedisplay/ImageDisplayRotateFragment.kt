package com.davemorrissey.labs.subscaleview.test.imagedisplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.test.databinding.ImagedisplayRotateFragmentBinding

class ImageDisplayRotateFragment : Fragment() {

    private lateinit var binding: ImagedisplayRotateFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ImagedisplayRotateFragmentBinding.inflate(inflater, container, false)

        val activity = activity as? ImageDisplayActivity
        binding.previous.setOnClickListener { activity?.previous() }
        binding.next.setOnClickListener { activity?.next() }

        binding.imageView.setImage(
            ImageSource.asset(requireContext(), "swissroad.jpg")
        )

        binding.rotate.setOnClickListener {
            binding.imageView.imageRotation = binding.imageView.imageRotation.rotateBy90Degrees()
        }

        return binding.root
    }
}