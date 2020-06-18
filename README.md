# CompeteFD
Compete Front Desk Automated Test Suite

Setup Instructions:

1. Download Windows Application Driver installer from https://github.com/Microsoft/WinAppDriver/releases
2. Run the installer on a Windows 10 machine where your application under test is installed and will be tested
3. Enable Developer Mode in Windows settings
4. Configure Windows System Environment Variable
  - Value "CompeteFD_HOME"
  - Path "C:\Users\[username]\eclipse-workspace\CompeteFD"
    * Replace 'username' with your own Windows username
  - Reboot computer
5. Download and install Accessibility Insights from https://aka.ms/accessibilityinsights-windows/download

To Run Test:
1. Run WinAppDriver.exe from the installation directory (E.g. C:\Program Files (x86)\Windows Application Driver)
2. Execute tests in Eclipse as normal

For more information, https://github.com/microsoft/WinAppDriver/blob/master/README.md

    
