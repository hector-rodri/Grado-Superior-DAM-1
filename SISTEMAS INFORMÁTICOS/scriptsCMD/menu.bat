@echo off
:menu
cls
echo MENU
echo 1. Nombre del ordenador
echo 2. Nombre de usuario
echo 3. Fecha y hora
echo 4. Salir
set /p opcion=Seleccione una opción:

if "%opcion%"=="1" goto computername
if "%opcion%"=="2" goto username
if "%opcion%"=="3" goto datetime
if "%opcion%"=="4" goto end

echo Opción no válida
pause
goto menu

:computername
echo Nombre del ordenador: %computername%
pause
goto menu

:username
echo Nombre de usuario: %username%
pause
goto menu

:datetime
echo Fecha y hora: %date% %time%
pause
goto menu

:end
echo Saliendo del script...
echo Gracias por usar mi script
pause
exit
