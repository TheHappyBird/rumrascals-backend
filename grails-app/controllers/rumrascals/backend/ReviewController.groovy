package rumrascals.backend

import grails.converters.JSON
import grails.rest.RestfulController
import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.BAD_REQUEST

class ReviewController extends RestfulController {
    static responseFormats = ['json', 'xml']

    ReviewController() {
        super(Review)
    }

    def index(Integer max) {
        println("show all reviews")
        def reviews = Review.getAll()
        render reviews as JSON
    }

    def show(Long id) {
        println("Show review $id")
        def review = Review.findById(id)
        if (review == null) {
            renderStatusWithMessage(BAD_REQUEST, "No review found with id: $id")
            return
        }

        render review as JSON
    }

    private def renderStatusWithMessage(HttpStatus status, String message) {
        response.status = status.value()
        def map = [message: message]
        render map as JSON
    }
}
