/* CS 125 - Intro to Computer Science
 * File Name: CS125_Lab4_Client.java
 * Java Programming
 * Lab 4 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: FirstName1 LastName1
 * Name 2: FirstName2 LastName2
 * Description: This file contains the source code for the Lab 4 client.
 */

public class CS125_Lab4_Client
{
	//////////////////////////////////////////////////////////
	// Main method calls the two different banner-creators
	public static void main(String[] args)
	{
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Mario Lopez & Drew Hurley");
		System.out.println("Lab 4");
		System.out.println("");
		
		CreatePsychedelicBanner();
		CreateCustomBanner();
	}
	
	//////////////////////////////////////////////////////////
	// Client code for creating a psychedelic banner
	static void CreatePsychedelicBanner()
	{
		PersonalizedFbBanner fbb = new PersonalizedFbBanner();

		for (int i = 0; i < 10000; i++)
		{
			fbb.DrawRandomFilledOval();
			fbb.DrawRandomFilledRectangle();
		}

		for (int i = 0; i < 3; i++)
		{
			fbb.DrawTextAtRandomLocation("CS is fun");
			fbb.DrawTextAtRandomLocation("Cool");
			fbb.DrawTextAtRandomLocation("Awesome");
			fbb.DrawTextAtRandomLocation("So Fun!");
		}
		fbb.DrawCenteredPicture("myPic.jpg", 30);
		fbb.writeImageToFile("LastName_Psych_FBB");

		System.out.println("Your psychedelic banner is ready!");
	}
	
	///////////////////////////////////////////////////////////
	// Client code for creating your custom banner
	static void CreateCustomBanner()
	{
		PersonalizedFbBanner fbb = new PersonalizedFbBanner();
		fbb.DrawCustomizedDecoration();
		fbb.DrawCenteredPicture("myPic.jpg", 30);
		fbb.writeImageToFile("LastName_Cust_FBB");

		System.out.println("Your custom banner is ready!");
	}
}
