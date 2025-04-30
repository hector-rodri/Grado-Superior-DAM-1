$folderNames = @("Carpeta1", "Carpeta2", "Carpeta3", "Carpeta4", "Carpeta5")

$basePath = "C:\TestFolders"

if (-Not (Test-Path $basePath)) {
    New-Item -Path $basePath -ItemType Directory | Out-Null
    Write-Output "La carpeta base C:\TestFolders ha sido creada"
}

foreach ($folderName in $folderNames) {
    $folderPath = Join-Path -Path $basePath -ChildPath $folderName
    if (-Not (Test-Path $folderPath)) {
        New-Item -Path $folderPath -ItemType Directory | Out-Null
        Write-Output "La carpeta $folderName ha sido creada en $basePath"
    } else {
        Write-Output "La carpeta $folderName ya existe en $basePath"
    }
}

pause