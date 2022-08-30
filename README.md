<?xml version="1.0" encoding="utf-8"?>
<androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:backgroundTint="#FFFFFF"
    tools:context=".ui.MainActivity">


    <FrameLayout
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="?attr/actionBarSize">

    </FrameLayout>


    <com.google.android.material.bottomappbar.BottomAppBar
        android:id="@+id/bottom_app_bar"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:layout_gravity="bottom"
        android:backgroundTint="@color/purple_200"
        app:contentInsetStart="0dp"
        app:fabAlignmentMode="center"
        app:fabAnimationMode="slide"
        app:fabCradleMargin="8dp"
        app:fabCradleRoundedCornerRadius="8dp"

        app:hideOnScroll="false"
        app:navigationIconTint="@color/purple_200">

        <com.google.android.material.bottomnavigation.BottomNavigationView
            android:id="@+id/bottom_nav_view"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/transparent"
            app:elevation="0dp"
            app:itemIconTint="@color/purple_enabled_color"

            app:itemTextColor="@color/purple_enabled_color"
            app:menu="@menu/bottom_nav_menu" />

    </com.google.android.material.bottomappbar.BottomAppBar>

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:backgroundTint="@color/purple_enabled_color"
        android:contentDescription="@string/content_description_fab"
        android:src="@drawable/ic_baseline_add_24"
        app:layout_anchor="@id/bottom_app_bar"
        app:rippleColor="@color/purple_enabled_color" />


</androidx.coordinatorlayout.widget.CoordinatorLayout>
