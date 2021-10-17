package com.example.andersentask5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class InfoFragment : Fragment(R.layout.fragment_info) {

    private lateinit var fragment: ListFragment
    private lateinit var name: String
    private lateinit var surName: String
    private lateinit var number: String
    private lateinit var check: String
    private lateinit var saveChanges: Button
    private lateinit var changeName: EditText
    private lateinit var changeSurName: EditText
    private lateinit var changeNumber: EditText
    private var widthDp = 0.0F
    private var heightDp = 0.0F

    companion object {
        private const val NAME_EXTRA = "NAME_EXTRA"
        private const val SURNAME_EXTRA = "SURNAME_EXTRA"
        private const val NUMBER_EXTRA = "NUMBER_EXTRA"
        private const val CHECK_EXTRA = "CHECK_EXTRA"
        fun newInstance(name: String, surName: String, number: String, check: String) = InfoFragment().also {
            it.arguments = Bundle().apply {
                putString(NAME_EXTRA, name)
                putString(SURNAME_EXTRA, surName)
                putString(NUMBER_EXTRA, number)
                putString(CHECK_EXTRA, check)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        widthDp = resources.displayMetrics.run { widthPixels / density }
        heightDp = resources.displayMetrics.run { heightPixels / density }
        name = requireArguments().getString(NAME_EXTRA, "")
        surName = requireArguments().getString(SURNAME_EXTRA, "")
        number = requireArguments().getString(NUMBER_EXTRA, "")
        check = requireArguments().getString(CHECK_EXTRA, "")
        requireActivity()
                .onBackPressedDispatcher
                .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        activity?.supportFragmentManager?.beginTransaction()?.run {
                            fragment = ListFragment.newInstance("", "", "", "0")
                            if (widthDp <= 600) replace(R.id.frameLayout, fragment)
                            commit()
                        }
                    }
                }
                )
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        changeName = view?.findViewById(R.id.etName)!!
        changeSurName = view?.findViewById(R.id.etSurName)!!
        changeNumber = view?.findViewById(R.id.etNumber)!!
        changeSurName.setText(surName)
        changeNumber.setText(number)
        changeName.setText(name)
        saveChanges = view?.findViewById(R.id.saveChanges)!!
        saveChanges.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.run {
                fragment = ListFragment.newInstance(changeName.text.toString(),
                        changeSurName.text.toString(), changeNumber.text.toString(), check)
                if (changeName.text.toString().isEmpty() ||
                        changeSurName.text.toString().isEmpty() ||
                        changeNumber.text.toString().isEmpty())
                    Toast.makeText(activity, "Enter data", Toast.LENGTH_SHORT).show()
                else replace(R.id.frameLayout, fragment)
                commit()
            }
        }
        super.onResume()
    }
}