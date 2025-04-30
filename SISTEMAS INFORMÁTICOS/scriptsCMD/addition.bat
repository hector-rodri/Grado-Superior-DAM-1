@echo off
set /p numero1=Introduce el primer numero:
set /p numero2=Introduce el segundo numero:
set /a suma=%numero1% + %numero2%
echo La suma de %numero1% y %numero2% es: %suma%
pause
