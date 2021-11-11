package groovy

import com.example.spockdemo.entity.Person
import spock.lang.Specification


/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa* @Date 2021-11-08 21:18
 */
class WithAndVerifyAllTest extends Specification {


    def "test person use with"() {
        given:
        def p = new Person(name: "yawn", age: 18, birthday: "1995-05-25")

        expect: "测试"
        p.name == "yawn"
        p.age < 15
        p.birthday == "1995-05-25"


    }

    def "test person use verifyAll"() {
        given: "init a person"
        def p = new Person(name: "yawn", age: 18, birthday: "1995-05-25")

        expect: "测试"
        verifyAll(p) {
            name == "yawn"
            age < 20
            birthday == "1995-05-25"
        }
    }


    def "没有参数的 verifyAll"() {
        when:
        def z1 = Math.pow(1, 2)
        def z2 = Math.pow(2, 2)
        def z3 = Math.pow(2, 3)

        then:
        verifyAll {
            z1 == 1
            z2 == 4
            z3 == 8
        }
    }
}