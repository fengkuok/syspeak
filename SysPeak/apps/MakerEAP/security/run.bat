@echo off
cd %~dp0
call mvn clean jetty:run

pause