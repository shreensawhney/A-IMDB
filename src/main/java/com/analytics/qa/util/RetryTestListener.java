package com.analytics.qa.util;

import org.testng.*;

import java.util.Iterator;

public class RetryTestListener extends TestListenerAdapter {      //retry on runtime



    @Override
    public void onTestFailure(ITestResult result) {

        Reporter.setCurrentTestResult(result);

        if(result.getMethod().getRetryAnalyzer().retry(result))
            result.setStatus(ITestResult.SKIP);

        Reporter.setCurrentTestResult(null);

    }

    @Override
    public void onFinish(ITestContext context) {
        Iterator<ITestResult> skippedTestCases = context.getSkippedTests().getAllResults().iterator();
        while (skippedTestCases.hasNext()) {
            ITestResult skippedTestCase = skippedTestCases.next();
            ITestNGMethod method = skippedTestCase.getMethod();
            if (context.getSkippedTests().getResults(method).size() > 0) {
                System.out.println("Removing:" + skippedTestCase.getTestClass().toString());
                skippedTestCases.remove();
            }
        }
    }



}