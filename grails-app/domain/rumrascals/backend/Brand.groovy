package rumrascals.backend

class Brand {

    String name
    String description
    String imageLink

    static belongsTo = [company: Company]
    static hasMany = [rums: Rum]

    static constraints = {
        name nullable: false
    }
}
