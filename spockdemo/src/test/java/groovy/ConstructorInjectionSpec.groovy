package groovy

import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import spock.lang.Specification
/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa* @Date 2021-11-11 21:29
 */
class ConstructorInjectionSpec extends Specification {
    public static final String TEST_METHOD_1 = "Test method 1"

    @Collaborator
    SomeOtherClass someOtherClass = Mock();

    @Subject  //创建一个实例，其余用@Mock（或@Spy）注解创建的mock将被注入到用该实例中。
    SomeClass systemUnderTest

    def "should inject collaborator into subject"() {
        given:
        someOtherClass.someMethod() >> TEST_METHOD_1

        when:
        String firstResult = systemUnderTest.someOtherClass.someMethod()

        then:
        firstResult == TEST_METHOD_1
        systemUnderTest.someOtherClass == someOtherClass
    }


    class SomeClass {
        SomeOtherClass someOtherClass

        SomeClass(SomeOtherClass someOtherClass) {
            this.someOtherClass = someOtherClass
        }
    }

    class SomeOtherClass {
        String someMethod() {
            "Some other class"
        }
    }

}