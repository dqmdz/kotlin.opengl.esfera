package physics

import com.badlogic.gdx.math.Vector3

class BallPhysics(
    private val bounds: Vector3,
    private val radius: Float,
    private val maxSpeed: Float = 10f
) {
    var position = Vector3(0f, 0f, 0f)
        private set
    
    var velocity = Vector3(5f, 5f, 3f)
        private set

    fun update(delta: Float) {
        // Actualizar posición
        position.add(
            velocity.x * delta,
            velocity.y * delta,
            velocity.z * delta
        )

        handleCollisions()
        limitSpeed()
    }

    private fun handleCollisions() {
        handleAxisCollision(Vector3.X, bounds.x, { position.x }, { position.x = it }, { velocity.x *= -1 })
        handleAxisCollision(Vector3.Y, bounds.y, { position.y }, { position.y = it }, { velocity.y *= -1 })
        handleAxisCollision(Vector3.Z, bounds.z, { position.z }, { position.z = it }, { velocity.z *= -1 })
    }

    private fun handleAxisCollision(
        axis: Vector3,
        bound: Float,
        getPosition: () -> Float,
        setPosition: (Float) -> Unit,
        reverseVelocity: () -> Unit
    ) {
        val currentPosition = getPosition()

        if (Math.abs(currentPosition) > bound - radius) {
            // Corregir posición
            setPosition(Math.signum(currentPosition) * (bound - radius))
            
            // Invertir velocidad
            reverseVelocity()
            
            // Añadir aleatoriedad en otros ejes
            addRandomVelocity(axis)
        }
    }

    private fun addRandomVelocity(excludeAxis: Vector3) {
        val randomChange = { (Math.random() * 2 - 1).toFloat() * 2 }
        
        if (excludeAxis != Vector3.X) velocity.x += randomChange()
        if (excludeAxis != Vector3.Y) velocity.y += randomChange()
        if (excludeAxis != Vector3.Z) velocity.z += randomChange()
    }

    private fun limitSpeed() {
        velocity.clamp(0f, maxSpeed)
    }
} 