package domain

/**
 * Расчет гидростатического давления
 * P = ρ * g * h
 */
object WaveCalculator {
    private const val WATER_DENSITY = 1025.0 // кг/м³ (морская вода)
    private const val GRAVITY = 9.81         // м/с²

    fun calculateHydrostaticPressure(depthMeters: Double): Double {

        return (WATER_DENSITY * GRAVITY * depthMeters) / 1000.0 // Результат в кПа
    }
}