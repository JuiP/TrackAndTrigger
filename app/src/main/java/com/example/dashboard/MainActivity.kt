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

//        val intent = Intent(this, Class.forName("com.example.login.LoginMainActivity"))
//        startActivity(intent)

        // get reference to button
        val btn_click_todo = this.findViewById<Button>(R.id.TODO)
        btn_click_todo.setOnClickListener {
//            val intent = Intent()
//            intent.setClassName(PACKAGE_NAME,“$PACKAGE_NAME.NotesActivity”)
//            startActivity(intent)

//            val launchIntent = packageManager.getLaunchIntentForPackage("com.example.todoapp")
//            startActivity(launchIntent)


            val intent = Intent(this, Class.forName("com.example.todoapp.NotesActivity"))
            startActivity(intent)
            }
        val btn_click_shopping = this.findViewById<Button>(R.id.Inventory)
        btn_click_shopping.setOnClickListener {
//            val intent = Intent()
//            intent.setClassName(PACKAGE_NAME,“$PACKAGE_NAME.NotesActivity”)
//            startActivity(intent)

//            val launchIntent = packageManager.getLaunchIntentForPackage("com.example.todoapp")
//            startActivity(launchIntent)

            val intent = Intent(this, Class.forName("com.digitalwebandmoney.shoppinglistreminder.StoresActivity"))
            startActivity(intent)
//            val intent = Intent(Intent.ACTION_MAIN)
//            intent.component =
//                ComponentName("com.digitalwebandmoney.shoppinglistreminder", "com.digitalwebandmoney.shoppinglistreminder.StoresActivity")
//            startActivity(intent)
        }
        val btn_click_meet = this.findViewById<Button>(R.id.Meet)
        btn_click_meet.setOnClickListener {
            val intent = Intent(this, Class.forName("com.example.reminderapp.ReminderMainActivity"))
            startActivity(intent)
        }
        val btn_click_share = this.findViewById<Button>(R.id.share)
        btn_click_share.setOnClickListener {
            val message: String = "Hello"

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to :"))
        }
        }
    }