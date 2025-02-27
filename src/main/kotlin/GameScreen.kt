import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g3d.ModelBatch
import com.badlogic.gdx.math.Vector3
import physics.BallPhysics
import rendering.BallRenderer
import rendering.Scene3D

class GameScreen(private val game: BouncingBallGame) : Screen {
    private val modelBatch = ModelBatch()
    private val scene = Scene3D(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
    
    private val ballRadius = 2f
    private val bounds = Vector3(10f, 10f, 10f)
    private val physics = BallPhysics(bounds, ballRadius)
    private val renderer = BallRenderer(ballRadius)

    override fun render(delta: Float) {
        physics.update(delta)
        renderer.updatePosition(physics.position)

        // Renderizar
        Gdx.gl.glViewport(0, 0, Gdx.graphics.width, Gdx.graphics.height)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f)
        Gdx.gl.glEnable(GL20.GL_DEPTH_TEST)

        modelBatch.begin(scene.camera)
        renderer.render(modelBatch, scene.environment)
        modelBatch.end()
    }

    override fun resize(width: Int, height: Int) {
        scene.resize(width.toFloat(), height.toFloat())
    }

    override fun dispose() {
        modelBatch.dispose()
        renderer.dispose()
    }

    override fun show() {}
    override fun pause() {}
    override fun resume() {}
    override fun hide() {}
} 