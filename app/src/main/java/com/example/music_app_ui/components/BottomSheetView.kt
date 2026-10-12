package com.example.music_app_ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.music_app_ui.data.bottomSheetItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetView(
    showBottomSheet: Boolean,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            ) {
                bottomSheetItems.forEach { item ->
                    BottomSheetRowView(
                        item = item,
                        onClick = onDismiss
                    )
                }
            }
        }
    }
}