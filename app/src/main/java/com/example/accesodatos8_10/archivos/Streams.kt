package com.example.accesodatos8_10.archivos

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter

class Streams {
    fun main(){
        println(readFilesStream(".\\fichero.txt"))

        writeFileStream(".\\fichero.txt",listOf("Mola", "aksjdlfk"))

        print(readFilesStream(".\\fichero.txt"))

    }

    //Leer
    fun readFilesStream(filePath:String): MutableList<String> {
        val lines = mutableListOf<String>()
        BufferedReader(FileReader(filePath)).use { myFileReader ->
            var line: String? = myFileReader.readLine()
            while (line != null) {
                lines.add(line)
                line=myFileReader.readLine()
            }
        }
        return lines
    }

    //Escribir

    fun writeFileStream(filePath:String,lines: List<String>) {
        BufferedWriter(FileWriter(filePath, true)).use { writer ->
            for (line in lines) {
                writer.write(line)
                writer.newLine()
            }
        }
    }
}