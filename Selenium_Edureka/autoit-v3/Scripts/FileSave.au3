WinWait("Save As");
WinActive("Save As");
Sleep(1000);
ControlSetText("Save As","","[CLASS:Edit; INSTANCE:1]","C:\Music_Ass\Badshah.mp3");
Sleep(1000);
ControlClick("Save As","","[CLASS:Button; INSTANCE:1]");
Sleep(1000);