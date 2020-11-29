package com.example.dashboard

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



import com.google.firebase.auth.FirebaseAuth
//import kotlinx.android.synthetic.main.activity_main.*


private const val PACKAGE_NAME = "com.example.todoapp"
class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent = Intent(this, Class.forName("com.example.login.LoginMainActivity"))
//        startActivity(intent)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser
        var setName = this.findViewById<TextView>(R.id.nameuser)
        setName.setText(currentUser?.email)

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
            val launchIntent = packageManager.getLaunchIntentForPackage("com.example.reminderapp")
            startActivity(launchIntent)
//            val intent = Intent(this, Class.forName("com.example.reminderapp.ReminderMainActivity"))
//            startActivity(intent)
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