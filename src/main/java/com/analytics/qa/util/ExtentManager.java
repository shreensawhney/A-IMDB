package com.analytics.qa.util;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager { //Not used


    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                extent = new ExtentReports(workingDir + File.separator
                        + "Extent.html", true);
            }
            else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                extent = new ExtentReports(workingDir + "/ExtentReports/ExtentReportResults.html", true);
            }
        }
        return extent;
    }
}

