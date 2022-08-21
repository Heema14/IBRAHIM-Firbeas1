<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:padding="15dp"
    android:orientation="vertical"
    tools:context=".RegisterActivity">


    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="58dp"
        android:text="Register"
        android:textSize="28sp"
        android:gravity="center"
        android:textStyle="bold"/>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/register_input_layout_fullname"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:layout_marginBottom="8dp"
        app:errorEnabled="true"
        style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

        <com.google.android.material.textfield.TextInputEditText

            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Full Name"
            android:inputType="text"
            android:drawableStart="@drawable/ic_outline_perm_identity_24"
            android:drawablePadding="10dp"/>
    </com.google.android.material.textfield.TextInputLayout>



    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/register_input_layout_username"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:layout_marginBottom="8dp"
        app:errorEnabled="true"
        style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

        <com.google.android.material.textfield.TextInputEditText

            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Username"
            android:inputType="text"
            android:drawableStart="@drawable/ic_outline_perm_identity_24"
            android:drawablePadding="10dp"/>
    </com.google.android.material.textfield.TextInputLayout>


    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/register_input_layout_Email"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:layout_marginBottom="8dp"
        app:errorEnabled="true"
        style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

        <com.google.android.material.textfield.TextInputEditText

            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Email"
            android:inputType="textEmailAddress"
            android:drawableStart="@drawable/ic_outline_email_24"
            android:drawablePadding="10dp"/>
    </com.google.android.material.textfield.TextInputLayout>


    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/register_input_layout_Password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        app:errorEnabled="true"
        app:passwordToggleEnabled="true"
        style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

        <com.google.android.material.textfield.TextInputEditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Password"
            android:inputType="textPassword"
            android:drawableStart="@drawable/ic_outline_lock_24"
            android:drawablePadding="10dp"/>
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/register_input_layout_rePassword"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        app:errorEnabled="true"
        app:passwordToggleEnabled="true"
        style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

        <com.google.android.material.textfield.TextInputEditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Re-Password"
            android:inputType="textPassword"
            android:drawableStart="@drawable/ic_outline_lock_24"
            android:drawablePadding="10dp"/>
    </com.google.android.material.textfield.TextInputLayout>


    <Button
        android:id="@+id/register_Btn_signup"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="15dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="15dp"
        android:backgroundTint="@color/blue"
        android:gravity="center"
        android:text="Sign Up"
        android:textAllCaps="false"
        android:textColor="@color/white"
        android:textSize="20sp"
        android:textStyle="bold" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="bottom"
        android:orientation="horizontal">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Already Have an Account,"
            android:textStyle="bold"
            android:layout_marginTop="15dp"
            android:textSize="16sp"
            android:gravity="end"/>

        <TextView
            android:id="@+id/register_tv_login"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="2"
            android:text=" Login"
            android:textColor="@color/blue"
            android:textStyle="bold"
            android:layout_marginTop="15dp"
            android:textSize="16sp"
            />

    </LinearLayout>





</LinearLayout>
