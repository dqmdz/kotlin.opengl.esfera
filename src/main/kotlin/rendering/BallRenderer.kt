package rendering

import com.badlogic.gdx.graphics.g3d.*
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.VertexAttributes.Usage
import com.badlogic.gdx.math.Vector3

class BallRenderer(radius: Float) {
    private val model: Model
    private val instance: ModelInstance

    init {
        val modelBuilder = ModelBuilder()
        val material = Material(
            ColorAttribute.createDiffuse(Color.RED),
            ColorAttribute.createSpecular(Color.WHITE),
            ColorAttribute.createAmbient(Color.RED.cpy().mul(0.5f))
        )
        
        model = modelBuilder.createSphere(
            radius * 2f, radius * 2f, radius * 2f,
            30, 30,
            material,
            (Usage.Position or Usage.Normal).toLong()
        )
        
        instance = ModelInstance(model)
    }

    fun updatePosition(position: Vector3) {
        instance.transform.setTranslation(position)
    }

    fun render(modelBatch: ModelBatch, environment: Environment) {
        modelBatch.render(instance, environment)
    }

    fun dispose() {
        model.dispose()
    }
} 