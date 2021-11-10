package groovy

import com.example.spockdemo.controller.HomeController
import com.example.spockdemo.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa* @Date 2021-11-09 23:00
 */
class HomeControllerSpec extends Specification {
    UserService userService;
    HomeController homeController
    ResponseEntity response

    def "mvc test"() {
        given:
        userService = Stub(UserService) {
            getHelloMessage(_) >> "hello world"
        }
        homeController = new HomeController(userService: userService)

        when:
        response = homeController.getHelloMessage(1)

        then:
        response.statusCode == HttpStatus.OK
        response.body == "hello world"
    }
}