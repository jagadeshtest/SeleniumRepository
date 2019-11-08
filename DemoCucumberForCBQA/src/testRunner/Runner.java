package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Feature",
		glue={"stepDefinition"},
		plugin={"com.cucumber.listener.ExtentCucumberFormatter:Output/report.html"}
		//tags={"@regression,@sanity"}
		//tags={"@sanity"}
		)
public class Runner {

}
