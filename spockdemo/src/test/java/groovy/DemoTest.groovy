package groovy


import com.example.spockdemo.entity.TestEntity
import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Title

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa* @Date 2021-11-03 8:24
 */
@Title("测试的标题")
@Narrative("""关于测试的大段文本描述""")
class DemoTest extends Specification {
    //在测试方法之间共享的数据
    @Shared
    TestEntity testEntity;

    // fields
    def obj = new TestEntity()

    // fixture methods
    def setup() {}          // run before every feature method
    def setupSpec() {}     // run before the first feature method
    def cleanupSpec() {}   // run after the last feature method
    def cleanup() {}        // run after every feature method

    // feature methods
    def "测试方法1"() {
        given:
        "给定一个前置条件"
        //TODO: code here
        and:
        "其他前置条件"

        expect:
        "随处可用的断言"
        //TODO: code here
        when:
        "当发生一个特定的事件"
        //TODO: code here
        and:
        "其他的触发条件"

        then:
        "产生的后置结果"
        //TODO: code here
        and:
        "同时产生的其他结果"


    }

    // helper methods


}