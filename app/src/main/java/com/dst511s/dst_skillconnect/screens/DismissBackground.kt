package com.dst511s.dst_skillconnect.screens

@Composable
fun DismissBackground(dismissState: DismissState) {
    val direction = dismissState.dismissDirection ?: return
    val color by animateColorAsState(
        when (dismissState.targetValue) {
            DismissValue.Default -> MaterialTheme.colorScheme.surface
            DismissValue.DismissedToEnd -> Color(0xFFFF5722)
            DismissValue.DismissedToStart -> Color(0xFFFF5722)
        }, label = "dismiss_background_color"
    )

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = when (direction) {
            DismissDirection.StartToEnd -> Arrangement.Start
            DismissDirection.EndToStart -> Arrangement.End
        }
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete",
            tint = Color.White
        )
    }
}
