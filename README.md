<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".AddPostActivity">
    <com.google.android.material.appbar.AppBarLayout
        android:id="@+id/app_bar_layout_add_post"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@android:color/white">

        <androidx.appcompat.widget.Toolbar
            android:id="@+id/add_post_toolbar"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:layout_marginLeft="6dp"
            android:layout_marginTop="4dp"
            android:layout_marginRight="6dp"
            android:background="@android:color/white">

            <RelativeLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content">

                <ImageView
                    android:id="@+id/close_add_post_btn"
                    android:layout_width="20dp"
                    android:layout_height="30dp"
                    android:layout_alignParentStart="true"
                    android:src="@drawable/close" />

                <ImageView
                    android:id="@+id/save_new_post_btn"
                    android:layout_width="30dp"
                    android:layout_height="30dp"
                    android:layout_alignParentEnd="true"
                    android:layout_marginRight="15dp"
                    android:src="@drawable/save_edited_info" />
            </RelativeLayout>

        </androidx.appcompat.widget.Toolbar>

    </com.google.android.material.appbar.AppBarLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:layout_marginTop="5dp"
        android:layout_below="@+id/app_bar_layout_add_post">
        <ImageView
            android:id="@+id/crop_image_view"
            android:layout_width="270dp"
            android:layout_height="270dp"
            android:layout_below="@+id/header"
            android:layout_gravity="center" />
        <EditText
            android:id="@+id/description_post"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:maxLines="6"
   android:hint="@string/say_something_about_your_post"
    />
    </LinearLayout>


</RelativeLayout>
