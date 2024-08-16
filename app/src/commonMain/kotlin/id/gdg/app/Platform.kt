package id.gdg.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform