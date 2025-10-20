package com.example.accesodatos8_10.archivos

import java.io.EOFException
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class StreamsBinarios {

    fun main() {
//    var content = StringBuilder()
//
//    FileInputStream(filepath).use

        writeBinaryStream(".\\fichero.dat",listOf("binario1","binario2","binario3","l",465,(Persona ("paco","martinez",58))))
        println(readBinaryStream(".\\fichero.dat"))
    }

//Funciones


    //Leer fichero binario
    fun readBinaryStream(filePath:String): MutableList<Any> {
        val elems = mutableListOf<Any>()
        ObjectInputStream(FileInputStream(filePath)).use { input ->
            while (true){
                try {
                    elems.add(input.readObject())
                }catch (e: EOFException){
                    break
                }

            }
        }
        return elems
    }

//Escribir fichero binario

    fun writeBinaryStream(filePath:String,data: List<Any>) {
        ObjectOutputStream(FileOutputStream(filePath)).use { file ->
            for (elem in data) {
                file.writeObject(elem)
            }
        }
    }
}