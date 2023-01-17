import java.util.Scanner

object CreateNotesMenu : Menu(), Interface {

    override var menuTitle: String = "\nВы в меню создания заметок:"
    override val menuItems: ArrayList<String> = arrayListOf(
        "Введите название заметки, затем введите саму заметку.",
        "Введите 0, чтобы выйти."
    )

    fun printMenu(archieveIndex: Int) {
        while (true) {
            outputData(menuItems, -1, false, error)
            var answer = inputData()
            when(answer) {
                "0" -> return
                else -> {
                    var noteTitle = answer
                    var noteDescription = inputData()
                    ArchiveMenu.createNote(archieveIndex, noteTitle, noteDescription)
                    println("Заметка '$noteTitle' успешно добавлена.")
                }
            }
        }
    }

    override fun inputData(): String {
        val scanner = Scanner(System.`in`)
        return scanner.nextLine()
    }

    override fun outputData(
        menuItems: ArrayList<String>,
        elementIndex: Int,
        hasError: Boolean,
        error: String
    ) {
        println(menuTitle)
        for (menuItem in menuItems) {
            println("${menuItem.toString()}")
        }
        println()
    }

}