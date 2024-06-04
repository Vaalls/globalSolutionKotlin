package vaalls.com.github.model

data class Praia (
    val name: String,
    val cidade: String,
    val estado:String,
    val onRemove: (Praia) -> Unit
    )

