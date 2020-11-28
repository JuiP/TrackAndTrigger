package com.example.dashboard

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


private const val PACKAGE_NAME = "com.example.todoapp"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to button
        val btn_click_todo = this.findViewById<Button>(R.id.TODO)
        btn_click_todo.setOnClickListener {
//            val intent = Intent()
//            intent.setClassName(PACKAGE_NAME,“$PACKAGE_NAME.NotesActivity”)
//            startActivity(intent)

//            val launchIntent = packageManager.getLaunchIntentForPackage("com.example.todoapp")
//            startActivity(launchIntent)

            val intent = Intent(Intent.ACTION_MAIN)
            intent.component =
                ComponentName("com.example.todoapp", "com.example.todoapp.NotesActivity")
            startActivity(intent)
            }
        val btn_click_shopping = this.findViewById<Button>(R.id.Inventory)
        btn_click_shopping.setOnClickListener {
//            val intent = Intent()
//            intent.setClassName(PACKAGE_NAME,“$PACKAGE_NAME.NotesActivity”)
//            startActivity(intent)

//            val launchIntent = packageManager.getLaunchIntentForPackage("com.example.todoapp")
//            startActivity(launchIntent)

            val intent = Intent(Intent.ACTION_MAIN)
            intent.component =
                ComponentName("com.digitalwebandmoney.shoppinglistreminder", "com.digitalwebandmoney.shoppinglistreminder.StoresActivity")
            startActivity(intent)
        }
        }
    }