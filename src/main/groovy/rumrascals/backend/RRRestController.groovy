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

    @Override
    def index(Integer max) {
        println("Fetching ${max ?: 'all'} ${resourceClassName}s")
        def list = resource.list(max: max)
        header 'Access-Control-Allow-Origin', "*"
        render list as JSON
    }

    @Override
    def show() {
        println("Show ${resourceClassName} ${params.id}")
        def item = resource.findById(params.id)
        if (item == null) {
            renderStatusWithMessage(BAD_REQUEST, "No ${resourceClassName} found with id: ${params.id}")
            return
        }

        header 'Access-Control-Allow-Origin', "*"
        render item as JSON
    }

    protected def renderStatusWithMessage(HttpStatus status, String message) {
        println("Error: " + message)
        response.status = status.value()
        def map = [message: message]
        render map as JSON
    }
}
