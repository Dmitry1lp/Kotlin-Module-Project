object Menu {

    fun showMenu(
        title: String,
        list: List<BaseClass>,
        onCreate: () -> Unit,
        onSelect: (index: Int) -> Unit,
        onExit: () -> Unit
    ) {
        println("\n$title")

        if (list.isEmpty()) {
            println("Список пуст.")
        } else {
            list.forEachIndexed { index, item ->
                when (item) {
                    is Archive -> println("${index + 1}. Архив: ${item.name}")
                    is Note -> println("${index + 1}. Заметка: ${item.name}")
                }
            }
        }

        println("${list.size + 1}. Создать новый элемент")
        println("${list.size + 2}. Выход")

        print("Введите номер пункта: ")
        val choice = try {
            val input = Reader.scanner.nextLine()
            input.toInt()
        } catch (e: NumberFormatException) {
            println("Неверный ввод. Введите число.")
            return showMenu(title, list, onCreate, onSelect, onExit)
        }
        when (choice) {
            in 1..list.size -> onSelect(choice - 1)
            list.size + 1 -> onCreate()
            list.size + 2 -> onExit()
            else -> {
                println("Неверный ввод. Попробуйте снова.")
                showMenu(title, list, onCreate, onSelect, onExit)
            }
        }
    }
}