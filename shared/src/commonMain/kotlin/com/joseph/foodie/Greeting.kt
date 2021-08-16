package com.joseph.foodie

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}