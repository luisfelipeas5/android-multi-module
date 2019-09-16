package br.com.luisfelipeas5.androidmultimodule

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.findNavController
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.*

class MainActivity : AppCompatActivity() {

    private lateinit var splitInstallManager: SplitInstallManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splitInstallManager = SplitInstallManagerFactory.create(this)
        SplitCompat.install(this)

        val dynamicFeature1 = getString(R.string.title_dynamicfeature1)
        if (splitInstallManager.installedModules.contains(dynamicFeature1)) {
            startDynamicFeature1()
        } else {
            downloadModule(dynamicFeature1)
        }
    }

    private fun downloadModule(dynamicFeature1: String) {
        val request = SplitInstallRequest.newBuilder()
            .addModule(dynamicFeature1)
            .build()

        splitInstallManager.registerListener(listener)
        splitInstallManager.startInstall(request)
            .addOnFailureListener { exception: Exception? ->
                if (exception is SplitInstallException) {
                    exception.printStackTrace()
                    Toast.makeText(this, exception.message, Toast.LENGTH_LONG).show()
                }
            }
            .addOnSuccessListener { startDynamicFeature1() }
            .addOnCompleteListener {}
    }

    private val listener = SplitInstallStateUpdatedListener { splitInstallSessionState -> splitInstallSessionState?.errorCode() }

    override fun onDestroy() {
        splitInstallManager.unregisterListener(listener)
        super.onDestroy()
    }

    private fun startDynamicFeature1() {
        setContentView(R.layout.activity_main)
    }
}
