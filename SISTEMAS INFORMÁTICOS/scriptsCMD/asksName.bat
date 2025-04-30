@echo off
set /p nombreCompleto=Dime tu nombre completo: 

if exist myname.txt (
    echo %nombreCompleto% >> myname.txt
    echo Tu nombre se ha añadido a myname.txt
) else (
    echo %nombreCompleto% > myname.txt
    echo myname.txt no existe, se ha creado y tu nombre se ha añadido
)

pause
