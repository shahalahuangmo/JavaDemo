package groovy

import com.example.spockdemo.controller.HomeController
import com.example.spockdemo.entity.UserInfo
import com.example.spockdemo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.mock.DetachedMockFactory

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa* @Date 2021-11-09 23:00
 */
@WebMvcTest
class HomeControllerSpec extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    UserService userService

    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(HomeController.class).build()
    }

    @TestConfiguration
    static class MockConfig  {
        DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

        @Bean
        UserService userService() {
            return detachedMockFactory.Mock(UserService)
        }
    }

    def "mvc test"() {
        given:
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setAge(11);
        userInfo.setCity("北京市");
        userInfo.setUserName("test01");
        userService.getUserById(_ as Integer) >> userInfo

        when:
        def results = mockMvc.perform(MockMvcRequestBuilders.get("/home/getUserById/1"))

        then:
        results.andExpect(MockMvcResultMatchers.status().isOk())

    }




}