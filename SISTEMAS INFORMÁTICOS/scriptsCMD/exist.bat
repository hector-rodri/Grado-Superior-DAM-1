@echo off
set /p archivo=Introduce el nombre del archivo a verificar: 
if exist "%archivo%" (
    echo El archivo %archivo% existe.
) else (
    echo El archivo %archivo% no existe.
)
pause