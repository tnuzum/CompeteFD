set projectLocation="C:\Automation\Jenkins\.jenkins\workspace\Compete Front Desk\testNG.xml"
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause