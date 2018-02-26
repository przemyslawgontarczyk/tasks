call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runff
echo.
echo  RUNCRUD has errors - breaking work


:runff
Sleep 14
"C:\Program Files (x86)\Mozilla Firefox\firefox.exe" http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end


:end
echo.
echo Work is finished.