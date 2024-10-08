package id.gdg.network

import de.jensklingenberg.ktorfit.converter.CallConverterFactory
import de.jensklingenberg.ktorfit.converter.FlowConverterFactory
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object NetworkClient {

    val get = ktorfit {
        baseUrl(Url.BASE)
        httpClient(HttpClient {
            install(ContentNegotiation) {
                json(Json { isLenient = true; ignoreUnknownKeys = true })
            }
            install(Logging) {
                logger = KtorLogger
                level = LogLevel.ALL
            }
        })
        converterFactories(
            FlowConverterFactory(),
            CallConverterFactory()
        )
    }

    object KtorLogger : Logger {

        override fun log(message: String) {
            println(message)
        }
    }
}