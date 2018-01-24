package rumrascals.backend

class Brand {

    String name
    String description

    static belongsTo = [company: Company]
    static hasMany = [rums: Rum]

    static constraints = {
        name nullable: false
    }
}
