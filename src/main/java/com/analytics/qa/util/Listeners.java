package com.analytics.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    public Listeners() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Page " + result.getInstanceName() + "TestCase " + result.getName() + " PASS");

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Page " + result.getInstanceName() + "TestCase " + result.getName() + " FAIL");

    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Page " + result.getInstanceName() + "TestCase " + result.getName() + " SKIPPED");

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {


    }
}
