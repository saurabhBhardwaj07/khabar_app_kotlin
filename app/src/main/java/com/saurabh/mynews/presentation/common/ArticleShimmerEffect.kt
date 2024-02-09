package com.saurabh.mynews.presentation.common

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.saurabh.mynews.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.saurabh.mynews.domain.model.Article
import com.saurabh.mynews.presentation.Dimens

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition()
    val alpha = transition.animateFloat(initialValue = 0.2f, targetValue = 0.9f , animationSpec = infiniteRepeatable(
        animation = tween(durationMillis = 1000),
        repeatMode = RepeatMode.Restart
    ) ).value
    background(color = colorResource(id = R.color.shimmer).copy(alpha))
}


@Composable
fun ArticleCardShimmerEffect(modifier: Modifier = Modifier){
    Row(modifier = modifier) {
        
        Box(
            modifier = Modifier
                .size(Dimens.ArticleCardSize)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround ,
            modifier = Modifier
                .padding(horizontal = Dimens.ExtraSmallPadding)
                .height(
                    Dimens.ArticleCardSize
                )
            ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(horizontal = Dimens.MediumPadding1)
                    .height(15.dp)
                    .shimmerEffect()
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(0.5f).padding( horizontal = Dimens.MediumPadding1).height(15.dp).shimmerEffect()
                ) {

                }
            }
        }


    }
}