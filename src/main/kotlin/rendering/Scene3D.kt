package rendering

import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.g3d.*
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight
import com.badlogic.gdx.graphics.g3d.environment.PointLight
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Vector3

class Scene3D(width: Float, height: Float) {
    val camera = PerspectiveCamera(67f, width, height).apply {
        position.set(20f, 20f, 20f)
        lookAt(0f, 0f, 0f)
        near = 1f
        far = 300f
        update()
    }

    val environment = Environment().apply {
        set(ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f))
        add(DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f))
        add(PointLight().set(Color.WHITE, Vector3(10f, 10f, 10f), 25f))
    }

    fun resize(width: Float, height: Float) {
        camera.viewportWidth = width
        camera.viewportHeight = height
        camera.update()
    }
} 