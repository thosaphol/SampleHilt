package com.example.samplehilt.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplehilt.ui.theme.SampleHiltTheme
import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

class LoginActivity : ComponentActivity() {

    val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleHiltTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Login(modifier = Modifier.padding(innerPadding))
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun Login(modifier: Modifier = Modifier,vm: LoginViewModel = viewModel()){

    val email by vm.email.collectAsState()
    val password by vm.password.collectAsState()

    Column(modifier = modifier){
        Row(modifier = Modifier.fillMaxWidth()){
            Text(text = "Email",modifier = Modifier.align(alignment = Alignment.CenterVertically).width(80.dp))
            Spacer(modifier = Modifier.padding(4.dp).width(3.dp).height(0.dp))
            TextField(value = email, placeholder =
                {
                    Text(text = "Enter Email")
                },
                modifier = Modifier.align(alignment = Alignment.CenterVertically).weight(1f),
                onValueChange = {
                    val tt = it
                }
            )

        }

        Spacer(modifier = Modifier.padding(4.dp).width(0.dp).height(3.dp))

        Row(modifier = Modifier.fillMaxWidth()){
            Text(text = "Password",modifier = Modifier.align(alignment = Alignment.CenterVertically).width(80.dp))
            Spacer(modifier = Modifier.padding(4.dp).width(3.dp).height(0.dp))
            TextField(value = password, placeholder =
                {
                    Text(text = "Enter Email")
                },
                modifier = Modifier.align(alignment = Alignment.CenterVertically).weight(1f).padding(0.dp),
                onValueChange = {
                    val tt = it
                }
            )

        }

        Button(onClick = {},modifier = Modifier.align(Alignment.CenterHorizontally)
            .padding(16.dp)){
            Text(text = "Login")
        }

        Button(onClick = {
            vm.SampleChange()
        },modifier = Modifier.align(Alignment.CenterHorizontally)
            .padding(16.dp)){
            Text(text = "Sample Change")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleHiltTheme {
        Greeting("Android")
    }
}