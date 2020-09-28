package com.examples.groovy

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class groovyexamples {

	//https://www.tutorialspoint.com/groovy/groovy_basic_syntax.htm
	@Keyword
	def hellowordfunction(){

		/* Using a simple println statement 
		 to print output to the console */
		println('Hello World');
	}


	//https://www.tutorialspoint.com/groovy/groovy_data_types.htm
	@Keyword
	def datatypesfunction(){

		//Example of a int datatype
		int x = 5;

		//Example of a long datatype
		long y = 100L;

		//Example of a floating point datatype
		float a = 10.56f;

		//Example of a double datatype
		double b = 10.5e40;

		//Example of a BigInteger datatype
		BigInteger bi = 30g;

		//Example of a BigDecimal datatype
		BigDecimal bd = 3.5g;

		println(x);
		println(y);
		println(a);
		println(b);
		println(bi);
		println(bd);
	}


	//https://www.tutorialspoint.com/groovy/groovy_variables.htm
	@Keyword
	def variablesfunction(){
		// Defining a variable in lowercase
		int x = 5;

		// Defining a variable in uppercase
		int X = 6;

		// Defining a variable with the underscore in it's name
		def _Name = "Joe";

		println(x);
		println(X);
		println(_Name);
	}


	//https://www.tutorialspoint.com/groovy/groovy_operators.htm
	@Keyword
	def arithmeticoperatorsfunction(){

		// Initializing 3 variables
		def x = 5;
		def y = 10;
		def z = 8;

		//Performing addition of 2 operands
		println(x+y);

		//Subtracts second operand from the first
		println(x-y);

		//Multiplication of both operands
		println(x*y);

		//Division of numerator by denominator
		println(z/x);

		//Modulus Operator and remainder of after an integer/float division
		println(z%x);

		//Incremental operator
		println(x++);

		//Decrementing operator
		println(x--);

	}


	@Keyword
	def relationaloperatorsfunction(){

		def x = 5;
		def y = 10;
		def z = 8;

		if(x == y) {
			println("x is equal to y");
		} else
			println("x is not equal to y");

		if(z != y) {
			println("z is not equal to y");
		} else
			println("z is equal to y");

		if(z != y) {
			println("z is not equal to y");
		} else
			println("z is equal to y");

		if(z<y) {
			println("z is less than y");
		} else
			println("z is greater than y");

		if(x<=y) {
			println("x is less than y");
		} else
			println("x is greater than y");

		if(x>y) {
			println("x is greater than y");
		} else
			println("x is less than y");

		if(x>=y) {
			println("x is greater or equal to y");
		} else
			println("x is less than y");

	}

	@Keyword
	def logicoperatorsfunction(){
		boolean x = true;
		boolean y = false;
		boolean z = true;

		println(x&&y);
		println(x&&z);

		println(x||z);
		println(x||y);
		println(!x);

	}

	@Keyword
	def bitwiseoperatorsfunction(){
		int a = 00111100;
		int b = 00001101;
		int x;

		println(Integer.toBinaryString(a&b));
		println(Integer.toBinaryString(a|b));
		println(Integer.toBinaryString(a^b));

		a=~a;
		println(Integer.toBinaryString(a));

	}

	@Keyword
	def assignmentoperatorsfunction(){
		int x = 5;

		println(x+=3);
		println(x-=3);
		println(x*=3);
		println(x/=3);
		println(x%=3);

	}

	//https://www.tutorialspoint.com/groovy/groovy_loops.htm
	@Keyword
	private int count = 0;

	def whileloopfunction(){
		while(count<10) {
			println(count);
			count++;
		}
	}

	@Keyword
	def forloopfunction(){
		//for(int i in array)
		//for(int i in 1..5)
		for(int i = 0;i<5;i++) {
			println(i);
		}

	}

	//https://www.tutorialspoint.com/groovy/groovy_decision_making.htm
	@Keyword
	def iffunction(){
		// Initializing a local variable
		int a = 2

		//Check for the boolean condition
		if (a<100) {
			//If the condition is true print the following statement
			println("The value is less than 100");
		}

	}

	@Keyword
	def ifelsefunction(){
		// Initializing a local variable
		int a = 2

		//Check for the boolean condition
		if (a<100) {
			//If the condition is true print the following statement
			println("The value is less than 100");
		} else {
			//If the condition is false print the following statement
			println("The value is greater than 100");
		}
	}

	@Keyword
	def switchfunction(){

		int a = 2

		//Evaluating the expression value
		switch(a) {
			//There is case statement defined for 4 cases
			// Each case statement section has a break condition to exit the loop

			case 1:
				println("The value of a is One");
				break;
			case 2:
				println("The value of a is Two");
				break;
			case 3:
				println("The value of a is Three");
				break;
			case 4:
				println("The value of a is Four");
				break;
			default:
				println("The value is unknown");
				break;
		}
	}
	//https://www.tutorialspoint.com/groovy/groovy_methods.htm
	//Note: Two method pattern
	@Keyword
	def summethod(int a,int b){

		int c = a+b
		println(c)

	}

	@Keyword
	def summethodinput(){
		//could be pulling numbers from a global
		summethod(3,5)

	}

	//https://www.tutorialspoint.com/groovy/groovy_maps.htm
	@Keyword
	def mapfunction(){
		def mp = ["TopicName" : "Maps", "TopicDescription" : "Methods in Maps"]
		println(mp.containsKey("TopicName"));
		println(mp.containsKey("Topic"));
	}


}
