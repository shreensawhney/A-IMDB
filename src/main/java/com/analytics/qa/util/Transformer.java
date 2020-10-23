package com.analytics.qa.util;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class Transformer implements IAnnotationTransformer {   //used with 1RetryAnalyzer 2.transformer 3.xml listener. Read 30 F tests


    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) { // Pass the parameters
        //annotation.setRetryAnalyzer(com.analytics.qa.util.RetryAnalyzer.class);                                                                //reflection api, where is the retry analyzer.

            IRetryAnalyzer retry = annotation.getRetryAnalyzer();

            if (retry == null)
                annotation.setRetryAnalyzer(RetryAnalyzer.class);

    }





}
