package id.gdg.event.data.fake

import kotlinx.serialization.json.Json

abstract class Faker {

    abstract fun json(): String

    inline fun <reified T> create(): T {
        return sharedJson.decodeFromString(json())
    }

    companion object {
        val sharedJson = Json { ignoreUnknownKeys = true }
    }
}