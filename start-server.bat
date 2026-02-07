@echo off
echo Server baslatiliyor...
echo Port: 5000
echo.
cd /d "%~dp0"
mvn compile exec:java -Dexec.mainClass="server.SimpleServer" -q
pause
