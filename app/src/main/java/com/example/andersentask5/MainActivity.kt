package com.example.andersentask5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var fragment: ListFragment
    private lateinit var fragment2: InfoFragment
    private var widthDp = 0.0F
    private var heightDp = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        widthDp = resources.displayMetrics.run { widthPixels / density }
        heightDp = resources.displayMetrics.run { heightPixels / density }
        supportFragmentManager.beginTransaction().run {
            fragment = ListFragment.newInstance("", "", "", "0")
            fragment2 = InfoFragment.newInstance("", "", "", "")
            replace(R.id.frameLayout, fragment)
            if (widthDp > 600 && heightDp > 600) replace(R.id.frameLayout2, fragment2)
            commit()
        }
    }

    fun firstElement(view: View) {
        val name = view.findViewById<TextView>(R.id.firstName).text
        val surName = view.findViewById<TextView>(R.id.firstSurname).text
        val number = view.findViewById<TextView>(R.id.firstNumber).text
        supportFragmentManager.beginTransaction().run {
            val infoFragment = InfoFragment.newInstance(name.toString(),
                    surName.toString(), number.toString(), "1")
            if (widthDp <= 600 || heightDp <= 600) replace(R.id.frameLayout, infoFragment)
            else replace(R.id.frameLayout2, infoFragment)
            commit()
        }
    }

    fun secondElement(view: View) {
        val name = view.findViewById<TextView>(R.id.secondName).text
        val surName = view.findViewById<TextView>(R.id.secondSurName).text
        val number = view.findViewById<TextView>(R.id.secondNumber).text
        supportFragmentManager.beginTransaction().run {
            val infoFragment = InfoFragment.newInstance(name.toString(),
                    surName.toString(), number.toString(), "2")
            if (widthDp <= 600 || heightDp <= 600) replace(R.id.frameLayout, infoFragment)
            else replace(R.id.frameLayout2, infoFragment)
            commit()
        }
    }

    fun thirdElement(view: View) {
        val name = view.findViewById<TextView>(R.id.thirdName).text
        val surName = view.findViewById<TextView>(R.id.thirdSurName).text
        val number = view.findViewById<TextView>(R.id.thirdNumber).text
        supportFragmentManager.beginTransaction().run {
            val infoFragment = InfoFragment.newInstance(name.toString(),
                    surName.toString(), number.toString(), "3")
            if (widthDp <= 600 || heightDp <= 600) replace(R.id.frameLayout, infoFragment)
            else replace(R.id.frameLayout2, infoFragment)
            commit()
        }
    }
}