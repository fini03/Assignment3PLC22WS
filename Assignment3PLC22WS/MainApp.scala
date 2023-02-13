/**
 * @author Lamies Abbas
 * @id 12128050
 */

import scala.io.Source

object MainApp {
    def main(args: Array[String]) = {
        val db = new Database
        val source = Source.fromFile("data.csv");
        for(line <- source.getLines().drop(1)) {
            val split = line.split(",")
            val id = split(0).toInt
            val name = split(1)
            val value = split(2).toInt

            val item = new StoreItem(id, name, value)
            db.store(item)
            //println(id, name, value)
        }
        println("--- SUM UP ---")
        println(db.sumUp())

        println("--- FILTERED BY ASUS ---")
        //db.search("ASUS")
        var filterASUS = db.filterByName("ASUS", db.getStoreItems)
        for(f <- filterASUS) {
            var name = f.name
            println(name)
        }
        println(filterASUS.size)

        println("--- FILTERED BY Lenovo ---")
        //db.search("Lenovo")
        var filterLenovo = db.filterByName("Lenovo", db.getStoreItems)
        for(f <- filterLenovo) {
            var name = f.name
            println(name)
        }
        println(filterLenovo.size)

        println("--- FILTERED BY HP ---")
        //db.search("HP")
        val filterHP = db.filterByName("HP", db.getStoreItems)
        for(f <- filterHP) {
            var name = f.name
            println(name)
        }
        println(filterHP.size)

        println("--- SORTED ITEMS ---")
        for(d <- db.sortByValueDesc()) {
            var name = d.name
            var value = d.value
            println(name + " " + value)
        }
    }
}
