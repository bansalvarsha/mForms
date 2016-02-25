WinWait("[CLASS:#32770]","",10)
 ControlFocus("File Upload","","Edit1")
 Sleep(2000)
 ControlSetText("File Upload", "", "Edit1", "D:\varsha\SeleniumWorkspace\MForms\AutoITTestData\How To Play Squash.mp4")
 Sleep(2000)
 ControlClick("File Upload", "","Button1");