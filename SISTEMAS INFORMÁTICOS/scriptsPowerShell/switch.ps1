$day = Read-Host "Introduce un día de la semana:"

switch ($day.ToLower()) {
    "lunes" { Write-Output "Es el inicio de la semana" }
    "martes" { Write-Output "Es martes, sigamos trabajando duro." }
    "miércoles" { Write-Output "Mitad de semana :)" }
    "jueves" { Write-Output "Es jueves, el fin de semana está cerca..." }
    "viernes" { Write-Output "¡Es viernes! Hora de relajarse pronto." }
    "sábado" { Write-Output "Es sábado, disfruta tu día libre." }
    "domingo" { Write-Output "Es domingo, recarga energías para la semana." }
    default { Write-Output "El día ingresado no es válido. Por favor, intenta de nuevo." }
}

pause