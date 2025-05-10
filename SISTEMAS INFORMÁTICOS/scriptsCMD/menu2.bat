@echo off

:MENU
cls
echo 1- Crear carpeta LOGS
echo 2- Crear 5 archivos 
echo 3- Anadir linea a cada archivo .log
echo 4- Salir

set /p opcion=Elige una opcion:

if "%opcion%"=="1" (
    if not exist LOGS 
    mkdir LOGS
    echo Carpeta LOGS creada

    goto MENU
)

if "%opcion%"=="2" (
    for /l %%i in (0,1,4) do (
        echo %USERNAME% %DATE% %TIME% > LOGS\log_%%i.log
    )
    goto MENU
)

if "%opcion%"=="3" (
    for %%f in (LOGS\*.log) do (
        echo %USERNAME% %DATE% %TIME% >> %%f
    )
    goto MENU
)

if "%opcion%"=="4" exit

goto MENU

pause
