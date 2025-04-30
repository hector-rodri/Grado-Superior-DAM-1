$filePath = "log.txt"

if (-Not (Test-Path $filePath)) {
    New-Item -Path $filePath -ItemType File | Out-Null
    Write-Output "El archivo 'log.txt' ha sido creado"
} else {
    Write-Output "El archivo 'log.txt' ya existe"
}

pause