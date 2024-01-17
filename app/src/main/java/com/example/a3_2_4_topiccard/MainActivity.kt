package com.example.a3_2_4_topiccard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a3_2_4_topiccard.data.DataSource
import com.example.a3_2_4_topiccard.model.Topic
import com.example.a3_2_4_topiccard.ui.theme._3_2_4_TopicCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _3_2_4_TopicCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicsApp()
                }
            }
        }
    }
}

@Composable
fun TopicsApp() {
    TopicList(topicList = DataSource.topics)
}

@Composable
fun TopicList(topicList: List<Topic>, modifier: Modifier = Modifier)
{
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_small)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(topicList) { topic ->
            TopicCard(topic)
        }
    }
}

@Composable
fun TopicCard(topic: Topic) {
    Card{
        Row{
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
                modifier = Modifier.size(dimensionResource(R.dimen.image_size)),
                contentScale = ContentScale.Crop
            )
            Column{
                Text(
                    text = stringResource(topic.stringResourceId),
                    modifier = Modifier.padding(
                        start= dimensionResource(R.dimen.padding_medium) ,
                        end= dimensionResource(R.dimen.padding_medium) ,
                        top= dimensionResource(R.dimen.padding_medium) ,
                        bottom= dimensionResource(R.dimen.padding_small)
                    ),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = stringResource(topic.stringResourceId),
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_medium)))
                    Text(
                        text = topic.cantidadCursos.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _3_2_4_TopicCardTheme {
        TopicsApp()
    }
}