
package com.example.trackntrigger;


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_email_register.*
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class EmailRegisterActivity : AppCompatActivity() {

    companion object {
        private const val RC_SIGN_IN = 120
    }

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    val pattern1 = Regex("^[a-zA-Z0-9_]+$")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_register)


        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()


        signUpEmail.setOnClickListener {
            if(!editTextPhone.text.toString().equals("")){
                if(validateUsername()) {
                    goToCreateAccount()
                }
                else{
                    Toast.makeText(baseContext, "Invalid Username",
                        Toast.LENGTH_SHORT).show()

                }
            }
            else{
                Toast.makeText(baseContext, "Invalid Phone Number",
                    Toast.LENGTH_SHORT).show()
            }


        }

    }

    private fun validateUsername() : Boolean {
        return pattern1.matches(editTextUserName.text.toString())
    }


    private fun goToCreateAccount() {
        val emailText: String = editTextTextRegisterEmailAddress.text.toString().trim { it <= ' ' }
        val passwordText: String = editTextTextPassword.text.toString().trim { it <= ' ' }
        val username: String = editTextUserName.text.toString()
        val phone: String = editTextPhone.text.toString()
        val profession: String = spinner.selectedItem.toString()
        createAccount(emailText, passwordText, username, phone, profession)
    }

    private fun createAccount(email: String, password: String, username: String, phone: String, profession: String) {


        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(baseContext, "Sign Up Successful.",
                                Toast.LENGTH_SHORT).show()
                        Log.d("SignUP", "createUserWithEmail:success")
                        val curruser = mAuth.currentUser
                        val user = hashMapOf(
                                "uiid" to curruser?.uid,
                                "email" to email,
                                "username" to username,
                                "phone" to phone, "profession" to profession
                        )
                        val uid = curruser?.uid.toString()
                        db.collection("users").document(uid).set(user)
                                .addOnSuccessListener { documentReference ->
                                    Log.d("TAG", "DocumentSnapshot added")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("TAG", "Error adding document", e)
                                }

                        val intent = Intent(this, SignInActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("SignUp", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()

                    }
                }
    }
}

