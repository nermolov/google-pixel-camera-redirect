package com.google.android.apps.photos.pager

import android.app.KeyguardManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity

class HostPhotoPagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val keyguard = getSystemService(KeyguardManager::class.java)
        if (keyguard.isKeyguardLocked) {
            keyguard.requestDismissKeyguard(this, object : KeyguardManager.KeyguardDismissCallback() {
                override fun onDismissSucceeded() = forward()
                override fun onDismissCancelled() = finish()
                override fun onDismissError() = finish()
            })
        } else {
            forward()
        }
    }

    private fun forward() {
        val uri = intent.data
        try {
            startActivity(
                Intent(Intent.ACTION_VIEW)
                    .setDataAndType(uri, intent.type ?: uri?.let(contentResolver::getType))
                    .setPackage(IMMICH_PACKAGE)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        } catch (e: Exception) {
            Log.e(TAG, "Error launching Immich app", e)
        } finally {
            finish()
        }
    }

    companion object {
        private const val TAG = "HostPhotoPagerActivity"
        private const val IMMICH_PACKAGE = "app.alextran.immich"
    }
}
