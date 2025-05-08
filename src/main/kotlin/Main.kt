fun main() {
    val archives = mutableListOf<Archive>()

    while(true) {
        var exitApp = false

        Menu.showMenu(
            title = "Меню архивов:",
            list = archives,
            onCreate = {
                val archive = Archive("", mutableMapOf())
                archive.create()
                archives.add(archive)
            },
            onSelect = { index ->
                val archive = archives[index]
                var backMenu = false

                while(!backMenu) {
                    val noteList = archive.noteList.map { (name, content) -> Note(name, content) }.toMutableList()
                    Menu.showMenu(
                        title = "Меню заметок",
                        list = noteList,
                        onCreate = {
                            val note = Note("","")
                            note.create()
                            archive.addNote(note)
                        },
                        onSelect = { noteIndex ->
                            val note = Note(
                                archive.noteList.keys.elementAt(noteIndex),
                                archive.noteList.values.elementAt(noteIndex)
                            )
                            note.showContent()
                            println("Нажмите любую клавишу чтобы продолжить")
                            readln()
                        },
                        onExit = { backMenu = true }
                    )
                }
            },
            onExit = {
                println("Выход из программы.")
                exitApp = true
            }
        )
        if(exitApp) break
    }
}