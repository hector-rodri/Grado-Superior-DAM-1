Write-Host "Introduce un numero:"
$numero = Read-Host

if ([int]$numero % 2 -eq 0) {
    Write-Host "$numero es par."
} else {
    Write-Host "$numero es impar."
}

pause