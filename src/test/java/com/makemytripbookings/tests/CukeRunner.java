package com.makemytripbookings.tests;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(

features = { "FeatureFile/" },

format = { "pretty", "html:target/cucumber-html-report", "junit:target/cucumber-junit-report/allcukes.xml" }, tags = { "@Runme" }

)
public class CukeRunner {

}
