$age = Read-Host "Introduce tu edad"

if ([int]$age -lt 18) {
    Write-Output "Eres menor de edad"
} else {
    Write-Output "Eres mayor de edad"
}

pause