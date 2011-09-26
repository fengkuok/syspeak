@echo off
cd %~dp0
call mvn  war:war jetty:run

pause