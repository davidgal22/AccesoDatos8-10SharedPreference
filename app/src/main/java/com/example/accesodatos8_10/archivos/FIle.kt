package com.example.accesodatos8_10.archivos

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

class FIle {
    fun main() {
        createFile(".\\fichero.txt")

        //leer todo seguido
        print(readFile(".\\fichero.txt"))

        //leer linea por linea
        val lines = readFile(".\\fichero.txt")
        for (line in lines) {
            println(line)
        }
        val lines2 = readFile(".\\fichero2.txt")
        for (line in lines2) {
            println(line)
        }

        writeFile(".\\fichero2.txt", listOf("hola", "linea2"))

    }


    //funcion de crear
    fun createFile(filePath: String) {
        val path = Paths.get(filePath)
        if (!Files.exists(path)) {
            Files.createFile(path)
        }
    }
    //funcion de leer
    fun readFile(filePath: String): List<String>{
        val path = Paths.get(filePath)
        val lines = Files.readAllLines(path)
        return lines
    }

//funcion escribir, crear y poner texto al final

    fun writeFile(filePath:String, content:List<String>) {
        val path = Paths.get(filePath)
        Files.write(path,content, StandardOpenOption.CREATE, StandardOpenOption.APPEND)
    }

}