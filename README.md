# IBRAHIM-Firbeas1

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ui.Registration.RegisterUserActivity"
    android:focusable="true"
    android:descendantFocusability="beforeDescendants"
    android:focusableInTouchMode="true">


    <androidx.core.widget.NestedScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scrollbars="none">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:paddingBottom="50dp"
            android:paddingHorizontal="20dp"
            android:orientation="vertical">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="30dp"
                android:text="@string/create_account"
                android:textColor="@color/purple_500"
                android:fontFamily="@font/montserrat_bold"
                android:textSize="32sp"
                android:layout_gravity="center"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginBottom="50dp"
                android:text="@string/enjoy_your_order"
                android:textSize="18sp"
                android:visibility="gone"
                android:fontFamily="@font/montserrat_semi_bold"
                android:layout_gravity="center"/>

            <com.google.android.material.textfield.TextInputLayout
                android:id="@+id/full_name"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:errorEnabled="true"
                style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

                <com.google.android.material.textfield.TextInputEditText
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="@string/full_name"
                    android:inputType="text"
                    android:drawableStart="@drawable/ic_user"
                    android:drawablePadding="10dp"/>

            </com.google.android.material.textfield.TextInputLayout>
            <com.google.android.material.textfield.TextInputLayout
                android:id="@+id/register_email_til"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:errorEnabled="true"
                style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

                <com.google.android.material.textfield.TextInputEditText
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="@string/e_mail"
                    android:inputType="textEmailAddress"
                    android:drawableStart="@drawable/ic_email"
                    android:drawablePadding="10dp"/>

            </com.google.android.material.textfield.TextInputLayout>

            <com.google.android.material.textfield.TextInputLayout
                android:id="@+id/register_mobile_num_til"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:errorEnabled="true"
                style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

                <com.google.android.material.textfield.TextInputEditText
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:drawableStart="@drawable/ic_mobile"
                    android:drawablePadding="10dp"
                    android:hint="@string/mobile_number"
                    android:inputType="number"
                    android:maxLength="14" />

            </com.google.android.material.textfield.TextInputLayout>
            <com.google.android.material.textfield.TextInputLayout
                android:id="@+id/register_password_til"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:errorEnabled="true"
                app:passwordToggleEnabled="true"
                style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

                <com.google.android.material.textfield.TextInputEditText
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="@string/create_password"
                    android:inputType="textPassword"
                    android:drawableStart="@drawable/ic_password_1"
                    android:drawablePadding="10dp"/>

            </com.google.android.material.textfield.TextInputLayout>
            <com.google.android.material.textfield.TextInputLayout
                android:id="@+id/register_re_password_til"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:errorEnabled="true"
                app:passwordToggleEnabled="true"
                style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

                <com.google.android.material.textfield.TextInputEditText
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="@string/confirm_password"
                    android:inputType="textPassword"
                    android:drawableStart="@drawable/ic_password_2"
                    android:drawablePadding="10dp"/>

            </com.google.android.material.textfield.TextInputLayout>

            <ImageView
                android:id="@+id/register_employee_id_card_iv"
                android:visibility="gone"
                android:layout_width="wrap_content"
                android:layout_height="250dp"
                android:scaleType="fitStart"
                android:contentDescription="@string/your_id_card"/>

            <CheckBox
                android:id="@+id/register_check_box"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/i_agree_to_the_terms_conditions"
                android:textSize="14sp"
                android:fontFamily="@font/montserrat_regular"/>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal">

                <Button
                    android:layout_width="0dp"
                    android:layout_weight="1"
                    android:layout_height="wrap_content"
                    android:layout_marginHorizontal="5dp"
                    android:text="@string/preview"
                    android:textAllCaps="false"
                    android:textColor="@color/purple_500"
                    android:backgroundTint="@color/white"
                    android:onClick="openPreviewActivity"/>

                <Button
                    android:id="@+id/btn_register"
                    android:layout_width="0dp"
                    android:layout_weight="1"
                    android:layout_height="wrap_content"
                    android:layout_marginStart="5dp"
                    android:text="@string/register"
                    android:textAllCaps="false"
                    android:textColor="@color/white"
                    android:enabled="false"/>
            </LinearLayout>

            <LinearLayout
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="bottom|center"
                android:layout_marginTop="10dp"
                android:gravity="center"
                android:orientation="horizontal">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginEnd="5dp"
                    android:text="@string/already_have_a_account"
                    android:textColor="@color/purple_200"
                    android:textSize="15sp" />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:fontFamily="@font/montserrat_bold"
                    android:onClick="openLoginActivity"
                    android:text="@string/login"
                    android:textColor="@color/purple_500"
                    android:textSize="15sp" />
            </LinearLayout>

        </LinearLayout>

    </androidx.core.widget.NestedScrollView>

</androidx.constraintlayout.widget.ConstraintLayout>
