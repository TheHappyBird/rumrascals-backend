package rumrascals.backend

class Rum {

    String name
    String description
    Country brewedInCountry
    int price

    static belongsTo = [brand: Brand]
    static hasMany = [reviews: Review]

    static constraints = {
    }
}