package br.edu.ifsp.scl.ads.s5.pdm.autenticacaofirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.edu.ifsp.scl.ads.s5.pdm.autenticacaofirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // View binding
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instanciando view binding
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)
    }

    override fun onStart() {
        super.onStart()
        // Verificando se o usuário continua logado
        val email = AutenticadorFirebase.firebaseAuth.currentUser?.email
        if (email != null) {
            activityMainBinding.bemVindoTv.text = "Seja bem-vindo $email"
        }
        else {
            finish()
        }
    }

    fun onClick(view: View) {
        if (view == activityMainBinding.sairBt) {
            // Deslogar
            AutenticadorFirebase.firebaseAuth.signOut()
            finish()
        }
    }
}