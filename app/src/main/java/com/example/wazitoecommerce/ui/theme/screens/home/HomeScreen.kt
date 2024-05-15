package com.example.wazitoecommerce.ui.theme.screens.home

import android.annotation.SuppressLint
import android.content.Intent
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
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
import com.example.wazitoecommerce.navigation.BOOKS_URL
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.example.wazitoecommerce.navigation.VIEW_PRODUCTS_URL
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally



    ) {

        val mContext = LocalContext.current

        TopAppBar(
            title = {
                Text(
                    text = "FOR YOU",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    color = Color.White
                )},
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Blue),
            navigationIcon = {


                IconButton(onClick = {



                }) {
                    Image(painter = painterResource(id = R.drawable.pic1),
                        contentDescription ="hotel",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }


            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Notifications,
                        contentDescription = "settings",
                        tint = Color.Black)
                }

            }




        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = R.drawable.cop24),
                contentDescription = "car16",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop)



            //Lottie Animation
            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.books))
            val progress by animateLottieCompositionAsState(composition)

            val mContext = LocalContext.current

            LottieAnimation(composition, progress,
                modifier = Modifier.size(300.dp)
            )



            Text(text = "Let's get Educated",
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Cursive

            )

        }

        //End of box
        Spacer(modifier = Modifier.height(10.dp))

        Column (modifier = Modifier
            .verticalScroll(rememberScrollState())){
            Text(
                text = "Work Outs",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.padding(start = 20.dp))

            Spacer(modifier = Modifier.height(10.dp))

            //SEARCH BAR
            Spacer(modifier = Modifier.height(10.dp))
            var search by remember { mutableStateOf("") }



            OutlinedTextField(
                value = search,
                onValueChange ={search = it},
                placeholder = { Text(text = "Search")},
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),

                )
            //End of SearchBar

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Recently Viewed",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Red,
                fontFamily = FontFamily.Cursive,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 20.dp))

            Spacer(modifier = Modifier.height(10.dp))

            Row (
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ){
                //Card1
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)) {
                    Column {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cop34) ,
                                contentDescription = "car11",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)

                        }
                        Text(text = "Mathematics Pastpapers",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Blue,
                            fontFamily = FontFamily.Cursive,
                            fontSize = 20.sp)


                    }

                }

                //End of Card
                Spacer(modifier = Modifier.width(8.dp))
                //Card1
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)) {
                    Column {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.pic45) ,
                                contentDescription = "car11",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)

                        }
                        Text(text = "Chemistry Pastpapers",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Blue,
                            fontFamily = FontFamily.Cursive,
                            fontSize = 20.sp)


                    }

                }

                //End of Card
                Spacer(modifier = Modifier.width(8.dp))

                //Card1
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)) {
                    Column {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.pic47) ,
                                contentDescription = "car11",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)

                        }
                        Text(text = "Biology Pastpapers",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Blue,
                            fontFamily = FontFamily.Cursive,
                            fontSize = 20.sp)


                    }

                }

                //End of Card
                Spacer(modifier = Modifier.width(8.dp))

                //Card1
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)) {
                    Column {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cop31) ,
                                contentDescription = "car11",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)

                        }
                        Text(text = "Physics Pastpapers",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp)


                    }

                }

                //End of Card
                Spacer(modifier = Modifier.width(8.dp))

                //Card1
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)) {
                    Column {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cop36) ,
                                contentDescription = "car11",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)

                        }
                        Text(text = "English Pastpapers",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Blue,
                            fontFamily = FontFamily.Cursive,
                            fontSize = 20.sp
                        )

                    }

                }

                //End of Card
                Spacer(modifier = Modifier.width(8.dp))

                //Card1
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)) {
                    Column {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cop29) ,
                                contentDescription = "car11",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)

                        }
                        Text(text = "Kiswahili Pastpapers",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Blue,
                            fontFamily = FontFamily.Cursive,
                            fontSize = 20.sp)


                    }

                }

                //End of Card
                Spacer(modifier = Modifier.width(8.dp))


            }

            Spacer(modifier = Modifier.height(20.dp))

            //Card1
            Card(modifier = Modifier
                .clickable { navController.navigate(BOOKS_URL) }
                .width(370.dp)
                .height(200.dp)) {
                Column {
                    Box (modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center){

                        Image(painter = painterResource(id = R.drawable.cop14),
                            contentDescription ="car10",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds)
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

            //End of Card
            Spacer(modifier = Modifier.height(20.dp))

            //Row1
            Row (
                modifier = Modifier.padding(start = 20.dp)
            ){


                //Column1

                Column {
                    Card (
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)

                    ){

                        Box (modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center){
                            Image(painter = painterResource(id = R.drawable.cop34),
                                contentDescription ="car10",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds)

                            Text(
                                text = "Click here to Navigate to next Screen",
                                fontSize = 30.sp,
                                fontFamily = FontFamily.Serif,
                                color = Color.Blue
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
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text ="MATHEMATICS",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {

                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "443 reviews",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif)

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Let's get Educated",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Blue
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Row {
                        OutlinedButton(onClick = {
                            val shareIntent= Intent(Intent.ACTION_SEND)
                            shareIntent.type="text/plain"
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                            mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                        }) {
                            Text(text = "Message")

                        }
                        OutlinedButton(onClick = {
                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("brianmurimi120@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "APPLICATION FOR A JOB")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is Morris")
                            mContext.startActivity(shareIntent)
                        }) {
                            Text(text = "Email")



                        }
                    }





                }
                //End of Column1
                Spacer(modifier = Modifier.width(10.dp))

                //Column1

                Column {
                    Card (
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)

                    ){

                        Box (modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center){
                            Image(painter = painterResource(id = R.drawable.pic40),
                                contentDescription ="car10",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds)
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
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "CHEMISTRY",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {

                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "445 reviews",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif)

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Let's get Educated",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Blue
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Row {
                        OutlinedButton(onClick = {
                            val shareIntent= Intent(Intent.ACTION_SEND)
                            shareIntent.type="text/plain"
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                            mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                        }) {
                            Text(text = "Message")

                        }
                        OutlinedButton(onClick = {
                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("brianmurimi120@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "APPLICATION FOR A JOB")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is Morris")
                            mContext.startActivity(shareIntent)
                        }) {
                            Text(text = "Email")



                        }
                    }





                }
                //End of Column1

            }
            //End of Row1
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(modifier = Modifier.height(10.dp))


            //Row1
            Row (
                modifier = Modifier.padding(start = 20.dp)
            ){
                //Column1

                Column {
                    Card (
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)

                    ){

                        Box (modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center){
                            Image(painter = painterResource(id = R.drawable.cop31),
                                contentDescription ="car10",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds)
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
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "PHYSICS",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {

                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "447 reviews",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif)

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Let's get Educated",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Blue
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Row {
                        OutlinedButton(onClick = {
                            val shareIntent= Intent(Intent.ACTION_SEND)
                            shareIntent.type="text/plain"
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                            mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                        }) {
                            Text(text = "message")

                        }
                        OutlinedButton(onClick = {
                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("brianmurimi120@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "APPLICATION FOR A JOB")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is Morris")
                            mContext.startActivity(shareIntent)
                        }) {
                            Text(text = "Email")



                        }
                    }





                }
                //End of Column1
                Spacer(modifier = Modifier.width(10.dp))

                //Column1

                Column {
                    Card (
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)

                    ){

                        Box (modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center){
                            Image(painter = painterResource(id = R.drawable.cop32),
                                contentDescription ="car10",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds)
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
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "BIOLOGY",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {

                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "443 reviews",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif)

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Let's get Educated",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Blue
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Row {
                        OutlinedButton(onClick = {
                            val shareIntent= Intent(Intent.ACTION_SEND)
                            shareIntent.type="text/plain"
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                            mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                        }) {
                            Text(text = "Message")

                        }
                        OutlinedButton(onClick = {
                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("brianmurimi120@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "APPLICATION FOR A JOB")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is Morris")
                            mContext.startActivity(shareIntent)
                        }) {
                            Text(text = "Email")



                        }
                    }





                }
                //End of Column1

            }
            //End of Row1
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(modifier = Modifier.height(10.dp))


            //Row1
            Row (
                modifier = Modifier.padding(start = 20.dp)
            ){
                //Column1

                Column {
                    Card (
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)

                    ){

                        Box (modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center){
                            Image(painter = painterResource(id = R.drawable.cop39),
                                contentDescription ="car10",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds)
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
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "ENGLISH",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {

                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "443 reviews",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif)

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Let's get Educated",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Blue
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Row {
                        OutlinedButton(onClick = {
                            val shareIntent= Intent(Intent.ACTION_SEND)
                            shareIntent.type="text/plain"
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                            mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                        }) {
                            Text(text = "Message")

                        }
                        OutlinedButton(onClick = {
                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("brianmurimi120@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "APPLICATION FOR A JOB")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is Morris")
                            mContext.startActivity(shareIntent)
                        }) {
                            Text(text = "Email")



                        }
                    }





                }
                //End of Column1
                Spacer(modifier = Modifier.width(10.dp))

                //Column1

                Column {
                    Card (
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)

                    ){

                        Box (modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center){
                            Image(painter = painterResource(id = R.drawable.cop32),
                                contentDescription ="car10",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds)
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
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "KISWAHILI",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {

                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = Color.Blue)
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "443 reviews",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif)

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Let's get Educated",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Blue
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Row {
                        OutlinedButton(onClick = {
                            val shareIntent= Intent(Intent.ACTION_SEND)
                            shareIntent.type="text/plain"
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                            mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                        }) {
                            Text(text = "Let's get Educated")

                        }
                        OutlinedButton(onClick = {
                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("brianmurimi120@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "APPLICATION FOR A JOB")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is Morris")
                            mContext.startActivity(shareIntent)
                        }) {
                            Text(text = "Email")



                        }
                    }





                }
                //End of Column1

            }
            //End of Row1
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                navController.navigate(BOOKS_URL)
            },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Color.Red),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
            ) {
                Text(text = "Next")
            }


        }



















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
                    IconButton(onClick = { /*TODO*/ }) {
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
                    Text(text = "")

                }

            }

        )

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
fun HomeScreenPreview(){
    WazitoECommerceTheme {
        HomeScreen(navController = rememberNavController())
    }
}