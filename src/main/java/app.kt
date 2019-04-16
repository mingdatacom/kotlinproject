import com.google.gson.Gson

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
}