package org.wit.charitymark.models

import android.content.Context
import android.net.Uri
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import org.wit.charitymark.helpers.*
import timber.log.Timber
import java.lang.reflect.Type
import java.util.*

const val JSON_FILE = "charitymarks.json"
val gsonBuilder: Gson = GsonBuilder().setPrettyPrinting()
    .registerTypeAdapter(Uri::class.java, UriParser())
    .create()
val listType: Type = object : TypeToken<ArrayList<CharitymarkModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class CharitymarkJSONStore(private val context: Context) : CharitymarkStore {

    var charitymarks = mutableListOf<CharitymarkModel>()

    init {
        if (exists(context, JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<CharitymarkModel> {
        logAll()
        return charitymarks
    }

    override fun create(charitymark: CharitymarkModel) {
        charitymark.id = generateRandomId()
        charitymarks.add(charitymark)
        serialize()
    }


    override fun update(charitymark: CharitymarkModel) {
        // todo
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(charitymarks, listType)
        write(context, JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(context, JSON_FILE)
        charitymarks = gsonBuilder.fromJson(jsonString, listType)
    }

    private fun logAll() {
        charitymarks.forEach { Timber.i("$it") }
    }
}

class UriParser : JsonDeserializer<Uri>,JsonSerializer<Uri> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Uri {
        return Uri.parse(json?.asString)
    }

    override fun serialize(
        src: Uri?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(src.toString())
    }
}