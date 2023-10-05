package com.example.myapplication

import java.io.Serializable

data class PonyModel(

    val image: String,
    val name: String,
    val desc: String
) : Serializable
