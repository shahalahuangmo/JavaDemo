package groovy

import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa* @Date 2021-11-11 21:29
 */
class ConstructorInjection1Spec extends Specification {
    public static final String TEST_METHOD_1 = "Test method 1"

    //@Collaborator
    @Autowired
    SomeOther1Class someOther1Class = Mock()

    @Autowired
    SomeOther2rClass someOther2Class = Mock()

    @Subject
    SomeClass systemUnderTest

    def "should inject collaborator into subject"() {
        given:
        someOther1Class.someMethod() >> TEST_METHOD_1
        someOther2Class.someMethod() >> TEST_METHOD_1

        when:
        String firstResult1 = systemUnderTest.someOther1Class.someMethod()
        String firstResult2 = systemUnderTest.someOther2Class.someMethod()

        then:
        firstResult1 == TEST_METHOD_1
        firstResult2 == TEST_METHOD_1
        systemUnderTest.someOther1Class == someOther1Class
        systemUnderTest.someOther2Class == someOther2Class
    }


    class SomeClass {
        SomeOther1Class someOther1Class
        SomeOther2rClass someOther2Class

        SomeClass(SomeOther1Class someOther1Class, SomeOther2rClass someOther2Class) {
            this.someOther1Class = someOther1Class
            this.someOther2Class = someOther2Class
        }
    }

    class SomeOther1Class {
        String someMethod() {
            "Some other2 class"
        }
    }

    class SomeOther2rClass {
        String someMethod() {
            "Some other2 class"
        }
    }

}