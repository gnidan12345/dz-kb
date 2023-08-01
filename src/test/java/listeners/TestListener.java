package listeners;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


    public class TestListener  implements ITestListener {

        private static final Logger log = LogManager.getLogger(TestListener.class);


//        private static final Logger log = LogManager.getLogger(TestListener.class);

        @Override
        public void onTestStart(ITestResult result) {
            log.info(String.format("Test [%s] was started%n", result.getName()));
            Allure.addAttachment("Logs", "text/plain", String.format("Test [%s] was started%n", result.getName()));
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            log.info(String.format("Test [%s] was successful", result.getName()));
            Allure.addAttachment("Logs", "text/plain", String.format("Test [%s] was successful", result.getName()));
//            ITestListener.super.onTestSuccess(result);
        }

        @Override
        public void onTestFailure(ITestResult result) {
            ITestListener.super.onTestFailure(result);
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            ITestListener.super.onTestSkipped(result);
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        }

        @Override
        public void onTestFailedWithTimeout(ITestResult result) {
            ITestListener.super.onTestFailedWithTimeout(result);
        }

        @Override
        public void onStart(ITestContext context) {
            ITestListener.super.onStart(context);
        }

        @Override
        public void onFinish(ITestContext context) {
            ITestListener.super.onFinish(context);
        }
    }



