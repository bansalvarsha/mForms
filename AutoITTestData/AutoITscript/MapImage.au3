WinWait("[CLASS:#32770]","",10)
 ControlFocus("File Upload","","Edit1")
 Sleep(2000)
 ControlSetText("File Upload", "", "Edit1", "D:\varsha\workspace\mFormsAutomation\AutoITTestData\monarch.png")
 Sleep(2000)
 ControlClick("File Upload", "","Button1");