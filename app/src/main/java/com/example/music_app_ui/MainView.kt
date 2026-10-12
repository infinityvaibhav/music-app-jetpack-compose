package com.example.music_app_ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.music_app_ui.components.AccountDialog
import com.example.music_app_ui.components.BottomSheetView
import com.example.music_app_ui.components.BottomTabBarView
import com.example.music_app_ui.components.Navigation
import com.example.music_app_ui.data.Screen
import com.example.music_app_ui.data.allScreens
import com.example.music_app_ui.data.screensInDrawer
import com.example.music_app_ui.ui.theme.MusicappuiTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val viewModel: MainViewModel = viewModel()
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: screensInDrawer.first().route

    var isDialogOpen by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }

    // Synchronize TopBar title reactively with current route
    val currentTitle = remember(currentRoute) {
        allScreens.find { it.route == currentRoute }?.title ?: "Music App"
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                LazyColumn(modifier = Modifier.padding(vertical = 12.dp)) {
                    items(screensInDrawer) { item ->
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.titleMedium
                                )
                            },
                            selected = currentRoute == item.route,
                            onClick = {
                                scope.launch { drawerState.close() }
                                if (item.route == Screen.DrawerScreen.AddAccount.route) {
                                    isDialogOpen = true
                                } else {
                                    viewModel.setCurrentScreen(item)
                                    navController.navigate(item.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = item.title
                                )
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = currentTitle) },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Open navigation drawer"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { showBottomSheet = true }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More options"
                            )
                        }
                    }
                )
            },
            bottomBar = { BottomTabBarView(navController = navController) }
        ) { innerPadding ->
            Navigation(
                navController = navController,
                padding = innerPadding
            )
            AccountDialog(
                isOpen = isDialogOpen,
                onDismiss = { isDialogOpen = false }
            )
            BottomSheetView(
                showBottomSheet = showBottomSheet,
                onDismiss = { showBottomSheet = false }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    MusicappuiTheme {
        MainView()
    }
}