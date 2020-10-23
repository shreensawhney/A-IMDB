package com.analytics.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {


    private int count = 0;
    private static int retryLimit = 1; //Run the failed test 2 times

   public boolean retry(ITestResult result) {

        /*if(count < retryLimit) {

            count++;

            return true;

        }*/

           if (!result.isSuccess()) {
                if (count < retryLimit) {
                    count++;

                    return true;
                }
            }
            return false;
        }

 /*   @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
            if (count < maxTry) {                            //Check if maxTry count is reached
                count++;                                     //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed and take base64Screenshot
                testUtil.extendReportsFailOperations(iTestResult);    //ExtentReports fail operations
                return true;                                 //Tells TestNG to re-run the test
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }*/
}



