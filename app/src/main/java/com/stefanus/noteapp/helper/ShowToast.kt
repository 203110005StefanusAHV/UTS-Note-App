package com.stefanus.noteapp

import android.content.Context
import android.widget.Toast

//untuk menambahkan aktivitas guna aplikasi lebih interaktif
fun Context.toast(message: String){
    Toast.makeText(this, message , Toast.LENGTH_SHORT).show()
}