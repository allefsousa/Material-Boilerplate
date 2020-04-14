package com.developer.allef.boilerplateapp.interfaces

interface Payload<T> {
    fun toModel(): T
}