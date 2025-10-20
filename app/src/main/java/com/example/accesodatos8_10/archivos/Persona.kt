package com.example.accesodatos8_10.archivos

import java.io.Serializable


data class Persona(
    val name: String,
    val lastname: String,
    val age :Int?
): Serializable