package com.example.ellogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.login_button)
        val loginUser = findViewById<EditText>(R.id.login_user)
        val loginPass = findViewById<EditText>(R.id.login_pass)
        val loginUserError = findViewById<TextView>(R.id.login_user_error)
        val loginPassError = findViewById<TextView>(R.id.login_pass_error)

        loginButton.setOnClickListener {

            if (checkLoginUser(loginUser.text.toString()) && checkLoginPass(loginPass.text.toString())){
                Toast.makeText(applicationContext, "Bienvenido al programa",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Usuario o contraseña inválidos",Toast.LENGTH_SHORT).show()
            }
        }

        val loginUserWatcher = object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                if (!checkLoginUser(loginUser.text.toString())){
                    loginUserError.text = "Dirección de correo inválida"
                } else {
                    loginUserError.text = ""
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        }
        loginUser.addTextChangedListener(loginUserWatcher)

        val loginPassWatcher = object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                if (!checkLoginPass(loginPass.text.toString())){
                    loginPassError.text = "Password inválido"
                } else {
                    loginPassError.text = ""
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        }
        loginPass.addTextChangedListener(loginPassWatcher)


    }
}

private fun checkLoginUser(userName: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(userName).matches()
}

private fun checkLoginPass(userPass: String): Boolean {
    if (userPass.length < 8) return false
    if (userPass.none { it in 'A'..'Z' }) return false
    if (userPass.none { it in 'a'..'z' }) return false
    if (userPass.none { it in '0'..'9' }) return false
    return userPass.none { it !in 'A'..'Z' && it !in 'a'..'z' && it !in '0'..'9' }
    //return userPass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])".toRegex())

}