package org.freedu.locationappnsda.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationViewModel : ViewModel() {
    private val firebaseAuth = FirebaseAuth.getInstance()

    // Login function with success and failure callbacks
    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess()
                } else {
                    onFailure(it.exception?.message ?: "Login failed.")
                }
            }
    }

    // Registration function with success and failure callbacks
    fun register(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess()
                } else {
                    onFailure(it.exception?.message ?: "Registration failed.")
                }
            }
    }

    // Get the current user's UID
    fun getCurrentUserId(): String {
        return firebaseAuth.currentUser?.uid ?: ""
    }

    // Check if user is logged in
    fun isLoggedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }

    // Get the current logged-in FirebaseUser
    fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }
}
