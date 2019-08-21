package com.BookIt.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        // features = "@target/rerun.txt",

        plugin = {
                "json:target/json-reports/cucumber.json",
                "html:target/cucumber-reports",
                "rerun:target/rerun.txt"

        },

        features = "src/test/resources/features/",
        glue = "com/BookIt/step_definitions/",
        dryRun=false,
        tags = "@smoke"


)
public class CukesRunner {


}


