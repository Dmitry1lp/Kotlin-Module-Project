import java.util.Scanner

object Reader {
val scanner = Scanner(System.`in`)

    fun inputCreate(text:String): String{
        println(text)

        var value = scanner.nextLine()
        while(value.isBlank()){
            println("Введено неправильное значение, используйте буквы и цифры!")
            println(text)
            value = scanner.nextLine()
        }
        return value
    }
}