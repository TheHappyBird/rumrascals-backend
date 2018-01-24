package rumrascals.backend

class Review {

    String title
    String descriptin
    String review
    float rating

    static belongsTo = [rum: Rum]

    static constraints = {
        title nullable: false
    }
}
