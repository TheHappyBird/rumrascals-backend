package rumrascals.backend

import grails.converters.JSON

class Review {

    String title
    String description
    String reviewText
    float rating

    static belongsTo = [rum: Rum]

    static constraints = {
        title nullable: false
    }

    static {
        JSON.registerObjectMarshaller(Review) {
            [
                    id         : it.id,
                    title      : it.title,
                    description: it.description,
                    reviewText : it.reviewText,
                    rating     : it.rating,
                    rum        : it.rum,
                    brand      : it.rum.brand.name,
                    banner     : it.rum.brand.imageLink
            ]

        }
    }
}
