package com.example.wazitoecommerce.ui.theme.screens.books


import android.annotation.SuppressLint
import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
import com.example.wazitoecommerce.navigation.ADD_PRODUCTS_URL
import com.example.wazitoecommerce.navigation.VIEW_PRODUCTS_URL
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksScreen(navController:NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopAppBar(title = {
            Text(text = "DASHBOARD",
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                color = Color.White)},
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Red),
            actions = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.Notifications,
                        contentDescription = "settings",
                        tint = Color.White)
                }
            })

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },


            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    IconButton(onClick = {navController.navigate(ADD_PRODUCTS_URL)}) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable{
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Card(modifier = Modifier
                        .clickable { navController.navigate(VIEW_PRODUCTS_URL) }
                        .width(370.dp)
                        .height(200.dp)
                    ) {
                        Column {
                            Box (modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center){

                                Image(painter = painterResource(id = R.drawable.cop16),
                                    contentDescription ="car10",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds)
                                Text(
                                    text = "View Books",
                                    fontSize = 30.sp,
                                    fontFamily = FontFamily.Cursive,
                                    color = Color.White

                                )

                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "favorite" ,
                                    tint = Color.White,
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(15.dp)
                                )
                                
                            }

                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Card(modifier = Modifier
                        .clickable { navController.navigate(ADD_PRODUCTS_URL) }
                        .width(370.dp)
                        .height(200.dp)
                    ) {
                        Column {
                            Box (modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center){

                                Image(painter = painterResource(id = R.drawable.cop16),
                                    contentDescription ="car10",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds)
                                Text(
                                    text = "Add Books",
                                    fontSize = 30.sp,
                                    fontFamily = FontFamily.Cursive,
                                    color = Color.White

                                )

                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "favorite" ,
                                    tint = Color.White,
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(15.dp)
                                )

                            }

                        }

                    }

                }

            }



        )

        Spacer(modifier = Modifier.height(15.dp))

        val mContext = LocalContext.current

        OutlinedButton(onClick = {

            val cameraIntent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (cameraIntent.resolveActivity(mContext.packageManager)!=null){
                mContext.startActivity(cameraIntent)
            }else{
                println("Camera app is not available")
            }
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(2.dp, Color.Blue)


        ) {
            Text(text = "Camera", color = Color.Cyan)
        }

    }
}



val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Login",
        route="login",
        selectedIcon=Icons.Filled.Person,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Signup",
        route="signup",
        selectedIcon=Icons.Filled.Face,
        unselectedIcon=Icons.Outlined.Face,
        hasNews = true,
        badges=1
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun BooksScreenPreview(){
    WazitoECommerceTheme {
        BooksScreen(navController = rememberNavController())
    }
}