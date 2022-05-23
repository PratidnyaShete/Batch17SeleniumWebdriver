package Session_12_MiniatureFramework_UsingJunit.variables;

import Session_12_MiniatureFramework_UsingJunit.utilities.RandomNumberGeneratorUtil;

public class SigninPageVariables {

static RandomNumberGeneratorUtil randomUtil = new RandomNumberGeneratorUtil();
	
	// Variables - SignIn Page
	public static final String SignInPageTitle = "Login - My Store";
	public static final String NewUserEmailID = "DemoUser"+randomUtil.randomNumberGengerator_000_00()+"@gmail.com";
}
