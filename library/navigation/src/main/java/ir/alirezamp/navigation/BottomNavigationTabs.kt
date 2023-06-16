package ir.alirezamp.navigation

//main bottom navigation screens
sealed class BottomNavigationTabs(
    var icon: Int,
    var enabledIcon: Int,
    var screenRoute: String,
) {

    object Home :
        BottomNavigationTabs(
            icon = R.drawable.ic_home,
            enabledIcon = R.drawable.ic_home_enabled,
            screenRoute = Destinations.NewsListScreen.route,
        )

    object Discover :
        BottomNavigationTabs(
            icon = R.drawable.ic_discover,
            enabledIcon = R.drawable.ic_discover_enabled,
            screenRoute = Destinations.NewsListScreen.route,
        )

    object AddNew :
        BottomNavigationTabs(
            icon = R.drawable.ic_add,
            enabledIcon = R.drawable.ic_add_enabled,
            screenRoute = Destinations.NewsListScreen.route,
        )

    object Save :
        BottomNavigationTabs(
            icon = R.drawable.ic_save,
            enabledIcon = R.drawable.ic_save_enabled,
            screenRoute = Destinations.NewsListScreen.route,
        )

    object Profile :
        BottomNavigationTabs(
            icon = R.drawable.ic_profile,
            enabledIcon = R.drawable.ic_profile_enabled,
            screenRoute = Destinations.NewsListScreen.route,
        )

}

