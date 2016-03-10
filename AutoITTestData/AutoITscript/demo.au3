#include <WinAPIFiles.au3>

Local Const $sPath1 = 'girl.png'
Local Const $sPath2 = 'AutoITTestData\girl.png'
Local Const $sPath3 = 'D:\varsha\workspace\mFormsAutomation\AutoITTestData\girl.png'

ConsoleWrite($sPath1 & ' => ' & _WinAPI_GetFullPathName($sPath1) & @CRLF)
ConsoleWrite($sPath2 & ' => ' & _WinAPI_GetFullPathName($sPath2) & @CRLF)
ConsoleWrite($sPath3 & ' => ' & _WinAPI_GetFullPathName($sPath3) & @CRLF)