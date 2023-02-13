/**
 * @author Lamies Abbas
 * @id 12128050
 */

class StoreItem(var id: Int, var name: String, var value: Int) extends Logger with Item {
    override def logAction(actionName: String, name: String): Unit = { println(s"$name $actionName") }
}
