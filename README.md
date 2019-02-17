# SanZawgyiUniTextView
Zawgyi အမွန္ေပၚဖို႔၊ Uni အမွန္ေပၚဖို႔ ဒီ textView ကို သံုးပါ



Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


Add the dependency

	dependencies {
	        implementation 'com.github.SanKoKo:SanZawgyiUniTextView:Tag'
	}


# Usage

For zawgyi

     <san.znu.textView.SanZawgyiTextView
        android:id="@+id/tvZg"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="99dp"
        android:text="TextView"
        android:textSize="24sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

For Uni

    <san.znu.textView.SanUniTextView
        android:id="@+id/tvUni"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
        
        
Sample project လည္းပါတာမို႔ လြယ္ကူစြာ အသံုးျပဳႏုိင္မယ္လို႔ယူဆပါတယ္။ 
