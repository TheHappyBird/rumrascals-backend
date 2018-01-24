package rumrascals.backend

import grails.converters.JSON
import grails.rest.RestfulController
import groovy.util.logging.Log4j
import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.BAD_REQUEST

@Log4j
abstract class RRRestController<T> extends RestfulController<T> {

    static responseFormats = ['json']

    RRRestController(Class<T> resource) {
        super(resource)
    }

    def index(Integer max) {
        log.info("Fetching ${max ?: 'all'} ${resourceClassName}s")
        println("Fetching ${max ?: 'all'} ${resourceClassName}s")
        def list = resource.list(max: max)
        render list as JSON
    }

    def show(Long id) {
        log.info("Show ${resourceClassName} $id")
        println("Show ${resourceClassName} $id")
        def item = resource.findById(id)
        if (item == null) {
            renderStatusWithMessage(BAD_REQUEST, "No ${resourceClassName} found with id: $id")
            return
        }

        render item as JSON
    }

    protected def renderStatusWithMessage(HttpStatus status, String message) {
        println("Error: " + message)
        response.status = status.value()
        def map = [message: message]
        render map as JSON
    }
}
