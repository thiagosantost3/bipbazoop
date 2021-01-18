package model
import com.zoop.bazoop.application.model.ClienteTO
import java.time.LocalDate
import java.util.Random

 class Cliente(
     var nome: String="A",
     var cpf : Cpf = Cpf("12345678910"),
     var data : LocalDate = LocalDate.of(2018,2,2),
     var id: Int = Random().nextInt(100000000)
) {

    fun cpfIsValid(cpf: Cpf): Boolean {

        var result = false

        if (cpf.value.length == 11) {

            print("Cliente com cpf valido")
            result = true
        }else{
            println("Cliente com cpf invalido")

        }
        return result


    }

  fun alterar(clienteTO:ClienteTO){
      this.also {
          it.cpf = Cpf(clienteTO.cpf!!)
          it.data = clienteTO.data!!
          it.nome = clienteTO.nome!!
      }

  }
   // private fun validateCPFLength(cpf: String) = cpf.length == 11



    fun imprimirInfo()
    {
        print("o nome $nome e cpf ${cpf.value} e a data de nasc ${data}")

    }

}
class Cpf( var value: String)