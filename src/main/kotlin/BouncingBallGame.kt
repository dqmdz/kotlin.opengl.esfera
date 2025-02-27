import com.badlogic.gdx.Game

class BouncingBallGame : Game() {
    override fun create() {
        setScreen(GameScreen(this))
    }
} 