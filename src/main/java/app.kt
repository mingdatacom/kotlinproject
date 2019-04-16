import com.google.gson.Gson
import java.net.URL
import com.google.gson.JsonObject
import com.sun.corba.se.spi.presentation.rmi.StubAdapter.request
import java.io.InputStreamReader
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import java.io.InputStream


data class Person(val name: String, val age: Int, val messages: List<String>) {
}

fun main(args: Array<String>) {
    println("helloworld")
    val json = """{"name": "PersonName", "age": "26", "messages" : ["Master Person","At Kotlin"]}"""
    //val gson = Gson().GsonBuilder().setPrettyPrinting().create()
    //val gsonBuilder = GsonBuilder().serializeNulls()
    //gsonBuilder.registerTypeAdapter(Person::class.java, PersonDeserializer())
    //val gson = gsonBuilder.create()
    val person = Gson().fromJson(json, Person::class.java)
    println(person)
    val sURL = "http://192.168.100.100:8400/baseDstu3/Organization?_format=json"
    val result = URL(sURL).readText()
    //println(result)
    val url = URL(sURL)
    val request = url.openConnection()
    request.connect()
    val jp = JsonParser() //from gson
    val root = jp.parse(InputStreamReader(request.getContent() as InputStream)) //Convert the input stream to a json element
    val rootobj = root.asJsonObject //May be an array, may be an object.
    val entryArray = rootobj.get("entry").asJsonArray
    println("array size =" +entryArray.size())
    val firstElement = entryArray.get(0).asJsonObject
    //val firstElement = entryArray[0].asJsonObject
    println(firstElement.get("resource").asJsonObject.get("id"))
}