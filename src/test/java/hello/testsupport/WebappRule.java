package hello.testsupport;

import org.junit.rules.ExternalResource;

import java.util.concurrent.atomic.AtomicInteger;

public class WebappRule extends ExternalResource {
  private final WebappTestSupport testSupport = new WebappTestSupport();
  private final AtomicInteger recursiveCallCount = new AtomicInteger(0);

  @Override
  protected void before() throws Throwable {
    if (recursiveCallCount.getAndIncrement() == 0) {
      testSupport.before();
    }
  }

  @Override
  protected void after() {
    if (recursiveCallCount.decrementAndGet() == 0) {
      try {
        testSupport.after();
      } catch (RuntimeException e) {
        throw e;
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  public int localPort() {
    return testSupport.localPort();
  }
}
