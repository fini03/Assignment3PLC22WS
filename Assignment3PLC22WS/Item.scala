trait Item {
    var id: Int
    var name: String
    var value: Int

    def set_id(idParameter: Int) { id = idParameter }
    def get_id(): Int = id

    def set_name(nameParameter: String) { name = nameParameter }
    def get_name(): String = name

    def set_value(valueParameter: Int) { value = valueParameter }
    def get_value(): Int = value
}
