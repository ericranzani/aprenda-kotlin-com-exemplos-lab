enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario (val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    
    //mocando os dados de usuários
    val usario1 = Usuario("Eric", "eric@gmail.com")
    val usario2 = Usuario("João", "joao@gmail.com")
    val usario3 = Usuario("Ana", "ana@gmail.com")
    val usario4 = Usuario("Bia", "bia@gmail.com")
    val usario5 = Usuario("Lucas", "lucas@gmail.com")
    
  	//mocando os dados dos conteudos em seus respectivos níveis
    val conteudoBasico = ConteudoEducacional("Introdução ao Kotlin", 60, Nivel.BASICO)
    val conteudoIntermediario = ConteudoEducacional("POO: Orientação ao Objeto com Kotlin", 90, Nivel.INTERMEDIARIO)
    val conteudoAvancado = ConteudoEducacional("Armazenamento de Dados Essencial em Apps Android com Kotlin", 120, Nivel.AVANCADO)
    
    val formacao1 = Formacao(conteudoBasico.nome, listOf(conteudoBasico))
    val formacao2 = Formacao(conteudoIntermediario.nome, listOf(conteudoIntermediario))
    val formacao3 = Formacao(conteudoAvancado.nome, listOf(conteudoAvancado))
    
    formacao1.matricular(usario1)
    formacao1.matricular(usario3)
    formacao1.matricular(usario5)
    formacao2.matricular(usario2)
    formacao2.matricular(usario4)
    formacao3.matricular(usario2)
    formacao3.matricular(usario1)
    formacao3.matricular(usario5)
    
    println("Lista de alunos inscrito no curso de nivel ${conteudoBasico.nivel} na formação ${formacao1.nome} com duração de ${conteudoBasico.duracao} são:") 
    formacao1.inscritos.forEach {
        Usuario -> println("Nome: ${Usuario.nome}, Email: ${Usuario.email}")
    }
    
    
    println("\r\nLista de alunos inscrito no curso de nivel ${conteudoIntermediario.nivel} na formação ${formacao2.nome} com duração de ${conteudoIntermediario.duracao} são:") 
    formacao2.inscritos.forEach {
        Usuario -> println("Nome: ${Usuario.nome}, Email: ${Usuario.email}")
    }
    
    
    println("\r\nLista de alunos inscrito no curso de nivel ${conteudoAvancado.nivel} na formação ${formacao3.nome} com duração de ${conteudoAvancado.duracao} são:") 
    formacao3.inscritos.forEach {
        Usuario -> println("Nome: ${Usuario.nome}, Email: ${Usuario.email}")
    }
}