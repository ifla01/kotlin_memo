package com.ina.board.ui

import androidx.compose.material.Surface
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun TodoInputDialog (
    action: () -> Unit,
    disAction: () -> Unit,
//    content: @Composable () -> Unit
) {
    Dialog(onDismissRequest = { /*TODO*/ }, ) {
        Surface(
            modifier = Modifier
                .width(200.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(5.dp),
            color = Color.White
        ) {
            DialogContent(
                action = { action.invoke() },
                disAction = {disAction.invoke()},
            )
        }
    }
}

@Composable
fun DialogContent(
    action: () -> Unit,
    disAction: () -> Unit,
) {
    val textState = remember {
        mutableStateOf("")
    }

    Column {
        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxSize()
        )
        Text(
            text = "할 일",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .padding(vertical = 8.dp),
            fontSize = 11.sp,
            lineHeight = 12.sp
        )
        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        )
        TextField(value = textState.value, onValueChange = { textValue -> textState.value = textValue })
        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
                ) {
            Button(
                onClick = {
                          disAction.invoke()
                }, modifier = Modifier
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("취소", fontSize = 12.sp)
            }
            Button(
                onClick = {
                          action.invoke()
                }, modifier = Modifier
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("추가", fontSize = 12.sp)
            }
        }
        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        )
    }
}