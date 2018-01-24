package rumrascals.backend

class Company {

    String name
    Country foundedInCountry
    int foundedYear

    static constraints = {
        name nullable: false
        foundedInCountry nullable: false
        foundedYear nullable: false
    }
}
