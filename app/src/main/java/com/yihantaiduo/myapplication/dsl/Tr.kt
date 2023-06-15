package com.yihantaiduo.myapplication.dsl

import java.lang.StringBuilder

class Tr {
    var childrend = ArrayList<Td>()
    fun td(block:Td.()->String){
        var td = Td()
        td.content = td.block()
        childrend.add(td)
    }
    fun html():String{
        var builder = StringBuilder()
        builder.append("\n\t<tr>")
        for (childtag in childrend){
            builder.append(childtag.html())
        }
        builder.append("\n\t</tr>")
        return builder.toString()
    }
}