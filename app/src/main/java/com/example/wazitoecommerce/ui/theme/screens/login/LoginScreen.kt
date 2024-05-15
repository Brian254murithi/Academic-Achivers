package com.example.wazitoecommerce.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.data.AuthViewModel
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.example.wazitoecommerce.navigation.SIGNUP_URL
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController:NavHostController){
    Column(
        modifier = Modifier .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .paint(
                painterResource(
                    id = R.drawable.cop24
                ),
                contentScale = ContentScale.FillBounds
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "Academic Achievers",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp,
            color = Color.White)
        Spacer(modifier = Modifier.height(40.dp))

        //Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.login))
        val progress by animateLottieCompositionAsState(composition)

        val mContext = LocalContext.current

        LottieAnimation(composition, progress,
            modifier = Modifier.size(300.dp)
        )


        Spacer(modifier = Modifier.height(5.dp))


        Text(
            text = "Login Here",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(30.dp))


        Box {
            Card{
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }

                OutlinedTextField(value = email , onValueChange = {email=it},
                    placeholder = { Text(text = "Enter your Email",
                        color = Color.Black)},
                    leadingIcon = { Icon(imageVector = Icons.Default.Email,
                        contentDescription = "icon for Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 20.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                OutlinedTextField(value = password,
                    onValueChange = {password=it},
                    placeholder = { Text(text = "Enter your Password",
                        color = Color.Black)},
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "icon for Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 20.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(20.dp))
                val context = LocalContext.current
                val authViewModel = AuthViewModel(navController, context)

                Button(onClick = {
                    authViewModel.login(email, password)
                },
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp)
                ) {
                    Text(text = "Login")
                }
                Spacer(modifier = Modifier.height(5.dp))

                Button(onClick = {
                    navController.navigate(SIGNUP_URL)
                },
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp)) {
                    Text(text = "Create an Account")
                }

            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Having Trouble Logging in? Here's how",
            color = Color.Black)


    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoginScreenPreview(){
    WazitoECommerceTheme {
        LoginScreen(navController = rememberNavController())
    }
}