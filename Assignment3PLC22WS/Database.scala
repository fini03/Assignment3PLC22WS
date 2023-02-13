/**
 * @author Lamies Abbas
 * @id 12128050
 */

class Database extends ShoppingCart {
    private var storedItems: Array[StoreItem] = new Array[StoreItem](0)

    override def search(name: String): Array[StoreItem] = {
        val foundItems = storedItems.filter(n => n.name.contains(name))

        if(foundItems.isEmpty) {
             println(s"$name not found")
        } else {
            foundItems.foreach(_.logAction("found", name))
        }

        foundItems
    }

    override def store(item: StoreItem): Array[StoreItem] = {
        storedItems = storedItems :+ item
        item.logAction("stored", item.name)
        storedItems
    }

    override def sumUp(): Int = {
        storedItems.map(x => x.value).sum
    }

    def filterByName(name: String, items: Array[StoreItem]): Array[StoreItem] = {
        val filterArray = items.filter(n => n.name.contains(name))
        val sortArray = filterArray.sortWith(_.value < _.value)

        sortArray
    }

    override def delete(id: Int): Array[StoreItem] = {
        var arrayWithoutItem: Array[StoreItem] = new Array[StoreItem](0)

        for(item <- storedItems) {
            if(item.id == id) {
                item.logAction("deleted",  item.name)
            } else {
                arrayWithoutItem = arrayWithoutItem :+ item
            }
        }

        storedItems = arrayWithoutItem
        storedItems
    }

    override def sortByValueAsc(): Array[StoreItem] = storedItems.sortBy(_.value)
    override def sortByValueDesc(): Array[StoreItem] = storedItems.sortBy(-_.value)

    def getStoreItems(): Array[StoreItem] = storedItems
}
