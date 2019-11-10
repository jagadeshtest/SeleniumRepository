package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
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
