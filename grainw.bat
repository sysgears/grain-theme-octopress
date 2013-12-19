@ECHO OFF

SETLOCAL ENABLEDELAYEDEXPANSION

SET ARGS=
SET STRIPFIRST=0

FOR %%A IN (%*) DO (
   SET ARGS=!ARGS!,%%~A
   SET STRIPFIRST=1
)

IF "%STRIPFIRST%" == "1" (SET ARGS=%ARGS:~1%)

CALL gradlew.bat grain "-Pargs=%ARGS%"

if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
exit /b 1

:mainEnd
ENDLOCAL
