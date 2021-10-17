package com.example.andersentask5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var name: String
    private lateinit var surName: String
    private lateinit var number: String
    private lateinit var check: String
    private lateinit var tvName: TextView
    private lateinit var tvSurName: TextView
    private lateinit var tvNumber: TextView

    companion object {
        private const val NAME_EXTRA = "NAME_EXTRA"
        private const val SURNAME_EXTRA = "SURNAME_EXTRA"
        private const val NUMBER_EXTRA = "NUMBER_EXTRA"
        private const val CHECK_EXTRA = "CHECK_EXTRA"

        fun newInstance(name: String, surName: String, number: String, check: String) = ListFragment().also {
            it.arguments = Bundle().apply {
                putString(NAME_EXTRA, name)
                putString(SURNAME_EXTRA, surName)
                putString(NUMBER_EXTRA, number)
                putString(CHECK_EXTRA, check)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        name = requireArguments().getString(NAME_EXTRA, "")
        surName = requireArguments().getString(SURNAME_EXTRA, "")
        number = requireArguments().getString(NUMBER_EXTRA, "")
        check = requireArguments().getString(CHECK_EXTRA, "")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        val nameInt: Int
        val surNameInt: Int
        val numberInt: Int
        when (check.toInt()) {
            1 -> {
                nameInt = R.id.firstName
                surNameInt = R.id.firstSurname
                numberInt = R.id.firstNumber
            }
            2 -> {
                nameInt = R.id.secondName
                surNameInt = R.id.secondSurName
                numberInt = R.id.secondNumber
            }
            else -> {
                nameInt = R.id.thirdName
                surNameInt = R.id.thirdSurName
                numberInt = R.id.thirdNumber
            }
        }
        tvName = view?.findViewById(nameInt)!!
        tvSurName = view?.findViewById(surNameInt)!!
        tvNumber = view?.findViewById(numberInt)!!
        if (name.isNotEmpty()) tvName.text = name
        if (surName.isNotEmpty()) tvSurName.text = surName
        if (number.isNotEmpty()) tvNumber.text = number
        super.onResume()
    }
}