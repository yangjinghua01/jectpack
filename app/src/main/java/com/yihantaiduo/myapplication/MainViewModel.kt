package com.yihantaiduo.myapplication

import androidx.core.content.contentValuesOf
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved:Int): ViewModel() {
var counter = countReserved;
}