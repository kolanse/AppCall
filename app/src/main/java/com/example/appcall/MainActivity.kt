package com.example.appcall

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the views
        val text = findViewById<EditText>(R.id.phone_number)
        val button = findViewById<Button>(R.id.call)

        //get the text and call the makeCall method
        button.setOnClickListener {
            val string = text.text.toString()
            makeCall(string)
        }

    }



    /**
     * Make a call
     */

    fun makeCall(string: String){
        val intent = Intent(Intent.ACTION_DIAL)
        val uriString = Uri.encode(string) // takes care of the special characters like '#'
        intent.data = Uri.parse("tel:$uriString")
        startActivity(intent)
    }
}