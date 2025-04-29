class Archive(override var name: String, var noteList: MutableMap<String,String>) : BaseClass(name)  {

    override fun create() {
        name = Reader.inputCreate("Введите наименование архива.")
        println("Архив успешно создан!")
    }

    override fun showContent(){
        println("Название: $name")
        noteList.forEach {(key, value) ->
            println(" -$key: $value")
        }
    }

    fun addNote(note: Note) {
        noteList[note.name] = note.content
    }
}