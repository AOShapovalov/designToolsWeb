package sao.web

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform