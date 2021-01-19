package br.edu.ifsp.scl.ads.s5.pdm.autenticacaofirebase

import com.google.firebase.auth.FirebaseAuth

object AutenticadorFirebase {
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
}