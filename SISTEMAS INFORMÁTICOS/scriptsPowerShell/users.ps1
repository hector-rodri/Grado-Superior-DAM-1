New-Item -Path "C:\UsersTest" -ItemType Directory -Force

for ($i = 1; $i -le 5; $i++) {
    $name = Read-Host "Escribe el nombre de usuario $i"
    $folder = "C:\UsersTest\$name"
    New-Item -Path $folder -ItemType Directory -Force
    "$name `n$(Get-Date)" | Out-File "$folder\info.txt"
}

Get-ChildItem "C:\UsersTest" -Directory
