package br.edu.ifsp.scl.ads.s5.pdm.autenticacaofirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.edu.ifsp.scl.ads.s5.pdm.autenticacaofirebase.databinding.ActivityAutenticacaoBinding

class AutenticacaoActivity : AppCompatActivity() {
    // View binding
    private lateinit var activityAutenticacaoBinding: ActivityAutenticacaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instanciando view binding
        activityAutenticacaoBinding = ActivityAutenticacaoBinding.inflate(layoutInflater)

        setContentView(activityAutenticacaoBinding.root)
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.cadastrarBt -> {
                startActivity(Intent(this, CadastrarActivity::class.java))
            }
            R.id.entrarBt -> {
                val email = activityAutenticacaoBinding.emailEt.text.toString()
                val senha = activityAutenticacaoBinding.senhaEt.text.toString()
                AutenticadorFirebase.firebaseAuth.signInWithEmailAndPassword(email, senha).addOnSuccessListener {
                    Toast.makeText(this, "Usuário $email autenticado com sucesso.", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(this, "Falha na autenticação do usuário.", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.recuperarSenhaBt -> {
                startActivity(Intent(this, RecuperarSenhaActivity::class.java))
            }
        }
    }
}