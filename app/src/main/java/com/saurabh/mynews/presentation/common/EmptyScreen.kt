package com.saurabh.mynews.presentation.common
import android.view.animation.AlphaAnimation
import android.webkit.ConsoleMessage
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import java.net.ConnectException
import java.net.SocketTimeoutException
import com.saurabh.mynews.R
import com.saurabh.mynews.ui.theme.LightRed
import java.sql.RowId

@Composable
fun EmptyScreen( error: LoadState.Error? = null){
    var message by remember {
        mutableStateOf(parseErrorMessage(error = error))
    }

    var icon by remember {
        mutableStateOf(R.drawable.ic_network_error)
    }

    if( error == null){
        message = "You have not saved news so far !"
    }

    var startAnimation by remember{
        mutableStateOf(false)
    }

    val alphaAnimation by animateFloatAsState(targetValue = if(startAnimation) 0.3f else 0f , animationSpec = tween(durationMillis = 1000))

    LaunchedEffect(key1 = true ){
        startAnimation = true
    }

    EmptyContent(alphaAnimation = alphaAnimation, message =message , iconId = icon)
}


@Composable
fun EmptyContent(alphaAnimation: Float , message: String, iconId: Int){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ){

        Icon(painter = painterResource(id = iconId), contentDescription = null ,
        tint = if(isSystemInDarkTheme()) Color.LightGray else Color.DarkGray,
            modifier = Modifier
                .size(120.dp)
                .alpha(alphaAnimation)
            )

        Text(text = message , modifier = Modifier
            .padding(10.dp)
            .alpha(alphaAnimation) , style = MaterialTheme.typography.bodyMedium , color = if(isSystemInDarkTheme()) Color.LightGray else Color.DarkGray )

    }
}


fun parseErrorMessage(error: LoadState.Error?): String {
    return  when(error?.error){
        is SocketTimeoutException -> {
            "Server Unavailable."
        }
        is ConnectException -> {
            "Internet Unavailable."
        }
        else -> {
            "Unknown Error"
        }
    }
}