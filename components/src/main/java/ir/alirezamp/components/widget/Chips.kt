@file:OptIn(ExperimentalMaterial3Api::class)

package ir.alirezamp.components.widget

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Chips(
    modifier: Modifier = Modifier,
    title: String,
) {
    Card(
        modifier = modifier
            .height(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(0.5f)
        ),
        shape = MaterialTheme.shapes.medium,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 6.dp, horizontal = 16.dp),
            text = title,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.labelMedium,
        )
    }
}


@Composable
fun Chips(
    modifier: Modifier = Modifier,
    title: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val backColor = if (enabled) MaterialTheme.colorScheme.primaryContainer
    else MaterialTheme.colorScheme.surface
    val textColor = if (enabled) MaterialTheme.colorScheme.onPrimaryContainer
    else MaterialTheme.colorScheme.onSurface
    Card(
        modifier = modifier
            .width(58.dp)
            .height(28.dp),
        colors = CardDefaults.cardColors(containerColor = backColor),
        shape = MaterialTheme.shapes.medium,
        enabled = !enabled,
        onClick = onClick,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 6.dp, horizontal = 16.dp),
            text = title,
            color = textColor,
            style = MaterialTheme.typography.labelMedium,
        )
    }
}