import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nomanr.composables.bottomsheet.BasicModalBottomSheet
import com.nomanr.composables.bottomsheet.rememberModalBottomSheetState

@Composable
fun BottomSheetSample() {
    val sheetState = rememberModalBottomSheetState()
    var showSheet by remember { mutableStateOf(false) }


    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            Modifier
                .align(Alignment.Center)
                .clickable { showSheet = true }) {
            BasicText("Open Bottom Sheet", Modifier.padding(16.dp))
        }

        if (showSheet) {
            BasicModalBottomSheet(onDismissRequest = { showSheet = false },
                sheetState = sheetState,
                containerColor = Color.White,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                dragHandle = { DragHandle() }) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    BasicText("Bottom Sheet", Modifier.padding(8.dp))

                    BasicText(
                        "This bottom sheet contains multiple types of content.", Modifier.padding(vertical = 8.dp)
                    )

                    var counter by remember { mutableStateOf(0) }
                    Box(
                        Modifier
                            .background(Color.Blue)
                            .padding(12.dp)
                            .clickable { counter++ }) {
                        BasicText("Counter: $counter")
                    }

                    Spacer(Modifier.height(16.dp))

                    // List Section
                    BasicText("List of Items:", Modifier.padding(bottom = 8.dp))
                    repeat(5) { index ->
                        BasicText("Item $index",
                            Modifier
                                .padding(vertical = 4.dp)
                                .clickable { })
                    }

                    Spacer(Modifier.height(16.dp))

                    // Scrollable Content
                    BasicText("Section:", Modifier.padding(bottom = 8.dp))
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(8.dp)
                            .background(Color.LightGray)
                    ) {
                        repeat(10) {
                            BasicText(
                                "Item $it", Modifier.padding(vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(Modifier.height(16.dp))

                    // Custom Layout Section
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(Color.Cyan), contentAlignment = Alignment.Center
                    ) {
                        BasicText("Custom Layout", Modifier.align(Alignment.Center))
                    }
                }
            }
        }
    }
}

@Composable
fun DragHandle() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp), contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(32.dp)
                .height(4.dp)
                .background(
                    color = Color.LightGray, shape = RoundedCornerShape(2.dp)
                )
        )
    }
}