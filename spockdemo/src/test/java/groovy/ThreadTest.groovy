package groovy

import org.spockframework.runtime.UnallowedExceptionThrownError
import org.spockframework.runtime.model.parallel.ExecutionMode
import spock.lang.Execution
import spock.lang.Ignore
import spock.lang.Specification
import spock.util.EmbeddedSpecCompiler
import spock.util.EmbeddedSpecRunner


/**
 * @Description: 描述内容
 * @Auther: pengnanfa
 * @Date: 2021/11/13 /3:04 下午
 */
class ThreadTest extends Specification {
    EmbeddedSpecRunner runner = new EmbeddedSpecRunner()

    def timeout

    def setup() {
        runner.configurationScript = {
            runner {
                 false
            }
        }
    }

    @Execution(ExecutionMode.CONCURRENT)
    def "feature method that completes in time"() {
        timeout = 500

        when:
        runFeatureMethodThatSleeps(0)

        then:
        noExceptionThrown()
    }

    @Ignore("sometimes fails due to changed rule semantics in JUnit 4.10")
    def "feature method that does not complete in time"() {
        timeout = 250

        when:
        runFeatureMethodThatSleeps(500)

        then:
        Exception e = thrown()
        e.message.contains "timed out"
    }

    private def runFeatureMethodThatSleeps(delay) {
        runner.runSpecBody """
@org.junit.Rule
org.junit.rules.Timeout timeout = new org.junit.rules.Timeout($timeout)

def foo() {
  setup:
  Thread.sleep($delay)
}
     """
    }

    def noExceptionThrown() {
        Throwable thrown = getSpecificationContext().getThrownException();
        if (thrown == null) return;
        throw new UnallowedExceptionThrownError(null, thrown);
    }
}