class Note(override var name: String,var content: String) : BaseClass(name) {

    override fun create() {
        name = Reader.inputCreate("Введите наименование Заметки.")
            .lowercase()
            .replaceFirstChar {it.uppercase()}
        content = Reader.inputCreate("Введите текст Заметки.")
        println("Заметка успешно создана!")
    }

    override fun showContent() {
        println("Заметка: $name")
        println("Содержание: $content")


    }
}