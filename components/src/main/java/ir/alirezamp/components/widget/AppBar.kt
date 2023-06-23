package ir.alirezamp.components.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.alirezamp.components.R
import ir.alirezamp.components.util.AppBarAction
import ir.alirezamp.components.util.IconButton
import ir.alirezamp.components.util.ImmutableList

@Stable
@Composable
fun AppBar(
    actions: ImmutableList<AppBarAction>,
    onClick: (action: AppBarAction) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
        ) {
            Row(
                modifier = Modifier.align(Alignment.CenterEnd),
                horizontalArrangement = Arrangement.Center,
            ) {
                actions.items.forEach { action ->
                    IconButton(
                        modifier = Modifier.padding(start = 8.dp),
                        onClick = {
                            onClick(action)
                        },
                    ) {
                        Icon(
                            painter = painterResource(id = action.iconId),
                            contentDescription = null,
                        )
                    }
                }
            }
            Image(
                painter = painterResource(id = R.drawable.mo_news),
                modifier = Modifier
                    .size(70.dp, 34.dp)
                    .align(Alignment.Center),
                contentDescription = null,
            )

        }
    }
}