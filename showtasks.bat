call runcrud.bat

if "%ERRORLEVEL%" == "0" goto webBrowser
echo.
echo There were errors with runcrud - breaking work
goto fail

:webBrowser
@start http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo There were errors with web browser - breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.