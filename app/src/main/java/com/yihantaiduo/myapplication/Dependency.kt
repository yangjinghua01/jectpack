package com.yihantaiduo.myapplication



class Dependency {
    val libraries = ArrayList<String>()
    fun implementation(lib:String){
        libraries.add(lib)
    }
    fun dependencies(block:Dependency.()->Unit):List<String>{
        val dependency =Dependency()
        dependency.block()
        return dependency.libraries;
    }
    fun gaojie(funs:(I:Int)->Unit):Int{
        funs(1)
        return 1
    }
}
class  testP{
    fun testfun(){

    }
    fun gaojie(funs:testP.(i:Int)->Unit):Int{
        var testP = testP()
        testP.gaojie(funs)
        return 1
    }
}

fun main() {
    val p = Dependency()
    p.gaojie {

    }
    var testP = testP()
    testP.gaojie {
        testfun()
    }
}