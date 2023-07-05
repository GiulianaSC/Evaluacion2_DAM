package com.giuliana.ec2_dam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.giuliana.ec2_dam.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var isEmailOk: Boolean=false
    private var isPasswordOk: Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding =ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vista()
    }
    private fun vista(){
        binding.email.editText?.addTextChangedListener { text ->
            binding.btnLogin.isEnabled=iaCorrecto(text.toString(),binding.password.editText?.text.toString())
        }
        binding.password.editText?.addTextChangedListener { text ->
            binding.btnLogin.isEnabled=iaCorrecto(binding.email.editText?.text.toString(),text.toString())
        }
        binding.btnLogin.setOnClickListener{
            val email = binding.email.editText?.text.toString()
            val password = binding.password.editText?.text.toString()
            if (iaCorrecto(email, password)) {
                if (email == "ejemplo@idat.edu.pe" && password == "123456") {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        "Credenciales de inicio de sesión inválidas",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun validarEmail(email:String){
        isEmailOk=!email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()

    }
    private fun validarContraseña(password:String){
        isPasswordOk=password.length >=4
    }
    private fun iaCorrecto(email: String ,password: String):Boolean{
        validarEmail(email)
        validarContraseña(password)
        return isPasswordOk && isEmailOk
    }
}