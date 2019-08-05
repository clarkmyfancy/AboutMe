package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // instead os using setContentView, we instruct onCreate to create the binding object with all the shit that
        // connects the layout to the activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


//        // set the click listener
////        findViewById<Button>(R.id.done_button).setOnClickListener {
////            addNickname(it)
////        }
        // now we access the button through the binding objecvt
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
//        val editText: EditText = findViewById(R.id.nickname_edit)
//        val nicknameTextView: TextView = findViewById(R.id.nickname_text)
//
//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE

        // now we access the views through the binding object
//        binding.nicknameText.text = bind  ing.nicknameEdit.text
//        binding.nicknameEdit.visibility = View.GONE
//        binding.doneButton.visibility = View.GONE
//        binding.nicknameText.visibility = View.VISIBLE

        // use apply to make code easier to read
        binding.apply {
            nicknameText.text = binding.nicknameEdit.text.toString()
            // inorder to refresh the ui with the new data
                // we need to invalidate all binding exporessions so that they get created with the new data
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
