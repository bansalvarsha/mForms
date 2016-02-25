WinWait("[CLASS:#32770]","",10)
 ControlFocus("File Upload","","Edit1")
 Sleep(2000)
 ControlSetText("File Upload", "", "Edit1", "D:\varsha\SeleniumWorkspace\MForms\AutoITTestData\I-Bet-My-Life.mp3")
 Sleep(2000)
 ControlClick("File Upload", "","Button1");