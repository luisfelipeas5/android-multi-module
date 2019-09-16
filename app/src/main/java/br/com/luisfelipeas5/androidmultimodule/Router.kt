package br.com.luisfelipeas5.androidmultimodule

import androidx.navigation.NavController

class Router(private val navController: NavController) {

    fun pushFeature2() {
        navController.navigate(R.id.dinamyc2)
    }

}
