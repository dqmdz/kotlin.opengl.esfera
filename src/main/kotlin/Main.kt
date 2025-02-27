import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

fun main() {
    val config = Lwjgl3ApplicationConfiguration().apply {
        setTitle("Pelota Rebotando")
        setWindowedMode(800, 480)
    }
    Lwjgl3Application(BouncingBallGame(), config)
} 