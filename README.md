# Rose Build Library 

At present the project is seeded with sample code, test cases for the sample code, gradle build file, gitlab-ci config file, and JaCoco coverage tool setup. The build process also retrieves the code coverage metrics and shows it in the build window of GitLab.

The following resources were used to setup the project:
* [Gradle JaCoco Plugin](https://docs.gradle.org/current/userguide/jacoco_plugin.html)
* [Gradle User Guide](https://docs.gradle.org/current/userguide/userguide.html), especially the following chapters:
	* [Chapter 7 - Java Quick Start](https://docs.gradle.org/current/userguide/tutorial_java_projects.html)
	* [Chapter 8 - Dependency Management](https://docs.gradle.org/current/userguide/artifact_dependencies_tutorial.html)
	* [Chapter 14 - More about Tasks](https://docs.gradle.org/current/userguide/more_about_tasks.html)

Please see the **build.gradle** and **.gitlab-ci.yml** for more detials.

## Eclipse Setup Instruction

The project was setup using Eclipse (Mars 1 - Java Developer). It can be downloaded from the [On-Campus AFS Server](http://www.rose-hulman.edu/class/csse/binaries/Eclipse/mars/). You will also need to install Gradle plugin from [Eclipse Marketplace](https://marketplace.eclipse.org/content/gradle-integration-eclipse-0). After that, the project can be built within Eclipse IDE.

To build the project in Eclipse, right-click on the project -> Run As -> Gradle Build ... -> Under Gradle task box, enter **build** -> Apply -> Run. Your build should start. Note that you must **install JDK 8 (not JRE)** for all of these to work. 

Netta - Test Engineer: Added images to the GUI and introduced new constructor (in addition to the default one). Also got counters and CardListener to work properly.

Haley - Used bottom up integration testing on the player class with the ACard class

Chase - I produced the test code that checks input on various methods in the player and card class. I added Mocking tests so that we can test certain methods using UnitTesting. Also, helped with some of the ideas on how to implement some of the logic.


Metric:
Goal: ensure that code is easily understandable so that when roles change in depth explaination is not required
Question: How large are our methods/how well are they documented?
Proxy measure: For each method created for the project:
        1) all methods should be documented as to their function
        2) methods should be kept at or under 15 lines.  
            *if addition lines are completely necessary thenthe documentation must more or less provide 
            a walkthrough of every detail in that method
            ** tests that go over 15 lines of code are allowed as long as they are also well documented
Data collection: use Eclipse metrics plug in to check the number of lines of code per method.  Overages will be ignored if the above (*) condition is met.      


Milestone: Initial Game State
Netta - Software Engineer: Used TDD to add cards to each player's hand and deck. Also added code to move cards from the center deck to the center field. Worked with Charlie (pair programming) to create the Board Class. 
Chase - I changed some of the GUI code so that it uses back end logic. I could not do much this milestone due to time-managment issues. I also noticed that we need logic for drawing cards with no deck as well as a getPower for the player. The GUI will need major refactoring due to the lack of integration between logic and GUI but rather a different set of logic. Also added some support for the board to be later used in the Card listener to better utilize the back end logic.


Milestone: Card Effects
Netta - Software Engineer: Got a better understanding of how Paramterized testing works. Added a parameterized test for the buyCard method.
All - held a code walkthrough on Thursday.


Milestone: Monsters 
Netta - Software Engineer in Test: Added java docs to all of the tests (except Parameterized test) and commented out one unnecessary test. Also added another Parameterized test (for testing Monsters and ACard in general for errors). Created AllTests to run all of the tests (was needed to get CodeCover to work). Got 100% code coverage for all classes (except GUI-related classes). Added Integration tests and some error checking for the GUI (not much to do).


Milestone: Banishing and Complex Effects
Netta - Test Engineer: Added image of opponents cards (can only see the back of the cards, since you aren't supposed to know what cards your opponent has).

Milestone: Constructs
Charlie - Software Engineer: Assissted Netta in implementing constructs through Behavior Driven Development
