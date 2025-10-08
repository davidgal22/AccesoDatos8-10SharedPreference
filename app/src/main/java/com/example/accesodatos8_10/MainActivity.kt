package com.example.accesodatos8_10

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.accesodatos8_10.ui.SharedPreferencesManager
import com.example.accesodatos8_10.ui.theme.AccesoDatos810Theme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val prefs = SharedPreferencesManager(this, getString(R.string.filename))
        setContentView(R.layout.mainlayout)
        findViewById<Button>(R.id.savebutton).setOnClickListener(){
            lifecycleScope.launch {
                val userInput = findViewById<EditText>(R.id.NameEditText).text.toString()
                prefs.saveString("username", userInput)
                val output = findViewById<TextView>(R.id.savedDatatextView)
                output.text = getString(R.string.saved_data, userInput)
            }
        }
        findViewById<Button>(R.id.loadButton).setOnClickListener(){
            lifecycleScope.launch {
                var value = prefs.getString("username")
                val output = findViewById<TextView>(R.id.savedDatatextView)
output.text = getString(R.string.current_data, value)
            }
        }
}
}


