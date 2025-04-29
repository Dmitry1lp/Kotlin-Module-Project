fun main() {
    val archives = mutableListOf<Archive>()

    while(true) {1
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

    /*fun showNotesMenu(archive: Archive) {
        val noteList = archive.noteList.map { (name, content) -> Note(name, content) }.toMutableList()

        Menu.showMenu(
            title = "Меню заметок",
            list = noteList,
            onCreate = {
                val note = Note("","")
                note.create()
                archive.addNote(note)
                showNotesMenu(archive)
            },
            onSelect = { index ->
                val note = Note(
                    archive.noteList.keys.elementAt(index),
                    archive.noteList.values.elementAt(index)
                )
                note.showContent()
            },
            onExit = { showArchiveMenu() }
        )
    }

    fun showArchiveMenu() {
        Menu.showMenu(
            title = "Меню архивов:",
            list = archives,
            onCreate = {
                val archive = Archive("", mutableMapOf())
                archive.create()
                archives.add(archive)
                showArchiveMenu()
            },
            onSelect = { index ->
                val archive = archives[index]
                showNotesMenu(archive)
            },
            onExit = {
                println("Выход из программы.")
                kotlin.system.exitProcess(0)
            }
        )
    }


    showArchiveMenu()
}*/