package com.yihantaiduo.myapplication

import org.junit.Test

import org.junit.Assert.*
import org.w3c.dom.DOMStringList

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun DSL(){
        var p = Dependency()
        p.dependencies {
            implementation("androidx.room:room-compiler:2.1.0")
            implementation("androidx.room:greendao:2.1.0")
            implementation("androidx.room:ormlite:2.1.0")
        }
    }
}