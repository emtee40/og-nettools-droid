package xyz.pisoj.holo1.model

data class Host(
    val host: String,
    val latencyMillis: Long?,
    val status: Status
) {
    enum class Status {
        Available,
        Warning,
        Error,
        Unavailable
    }
}

fun Boolean.toHostStatus(): Host.Status {
    return if(this) Host.Status.Available else Host.Status.Unavailable
}
