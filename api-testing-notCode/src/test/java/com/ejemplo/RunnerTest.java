package com.ejemplo;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.ejemplo.steps",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class RunnerTest {
}
