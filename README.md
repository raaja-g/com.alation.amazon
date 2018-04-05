Selenium Automation code for Automating amazon search with category Book. Simple Page Object model with extent reports implementation. Please refer the Wiki URL https://github.com/raaja-g/com.alation.amazon/wiki for more details on the Framework.

Assumptions:

Framework:
•	Have documented the Assumptions made in the framework below.

1.	Framework is build as a Maven project and the dependencies are added to the pom.xml file.
2.	Framework is a simple page objects model framework. Fore more details on the framework please refer the project wiki page https://github.com/raaja-g/com.alation.amazon/wiki
       a.	This type was chosen because we automate only 1 screen and 1 functionality.
       b.	This framework gives us the flexibility to reuse the methods created.
       c.	Currently the drop down is limited to Books category only.
       d.	We have parameterized this, such that this can be extended for other category and search criteria.
       e.	Only First book information would be printed.
3.	This is a TestNG project. We used Selenium version 3.5.1.
4.	We used java version 1.8 and JRE version 1.8.
5.	We used JAVA as our scripting language.
6.	We need to check-out the project from github and convert it to maven project and make changes to it, such that it uses project specific settings.
7.	This framework is designed to run the tests only in FIREFOX and CHROME browsers.
       a.	FIREFOX browser version v.57 and above.
       b.	CHROME browser version v.65 and above.

