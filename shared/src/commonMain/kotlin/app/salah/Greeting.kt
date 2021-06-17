package app.salah

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}