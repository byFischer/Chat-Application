@echo off
echo Client baslatiliyor...
echo.
cd /d "%~dp0"
mvn javafx:run -q
pause
