package com.yihantaiduo.myapplication.dsl

import java.lang.StringBuilder

class Table {
    private val children = ArrayList<Tr>()
    fun tr(block:Tr.()->Unit){
        val tr = Tr()
        tr.block()
        children.add(tr)
    }
    fun html():String{
        val builder = StringBuilder()
        builder.append("<table>")
        for (childtag in children){
            builder.append(childtag.html())
        }
        builder.append("\n</table>")
        return builder.toString()
    }
}