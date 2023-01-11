// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val id: Int, val nome: String, val login: String) {

    var score = 0 // score vai aumentando conforme os cursos são concluídos

    override fun toString() = "NOME = " + nome + "||| SCORE = " + score 

}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>() // lista de inscritos na formação

    override fun toString(): String {
        return "********************" + 
        "\nNOME = " + nome +
        "\nConteúdo = " + conteudos +
        "\nMatriculados = " + inscritos +
        "\n********************"
    }
    
    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    fun concluirConteudoEducacional(usuario: Usuario) {
        usuario.score += 60
    }

    fun concluirFormacao (usuario: Usuario) {
        usuario.score += 150
    }
}

fun main() {

    val dinoDaSilvaSauro = Usuario(1, "Dino da Silva Sauro", "dinosauro")
    val franDaSilvaSauro = Usuario(2, "Fran da Silva Sauro", "fransauro")
    val robbieSinclair = Usuario(3, "Robbie Sinclair", "robbiesinclair")
    val charleneDaSilvaSauro = Usuario(4, "Charlene da Silva Sauro", "charlenesauro")
    val babySinclair = Usuario(5, "Baby Sinclair", "babysinclair")

    val kotlinBasico = ConteudoEducacional("Kotlin Basico")
    val classes = ConteudoEducacional("Classes")
    val collections = ConteudoEducacional("Collections")

    val cursosKotlin = mutableListOf(kotlinBasico, classes, collections)

    val kotlinParaDinos = Formacao("Kotlin Para Dinos", cursosKotlin, Nivel.BASICO)

    kotlinParaDinos.matricular(dinoDaSilvaSauro, 
                                franDaSilvaSauro, 
                                robbieSinclair, 
                                charleneDaSilvaSauro, 
                                babySinclair)

    kotlinParaDinos.concluirConteudoEducacional(dinoDaSilvaSauro)
    kotlinParaDinos.concluirFormacao(dinoDaSilvaSauro)

    println(dinoDaSilvaSauro.toString())
    println(franDaSilvaSauro.toString())

    println(kotlinBasico.toString())

    println(kotlinParaDinos.toString())

}
