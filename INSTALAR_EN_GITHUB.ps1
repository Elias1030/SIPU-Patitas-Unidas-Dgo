$ErrorActionPreference = "Stop"

Write-Host "Configurando el repositorio SIPU..." -ForegroundColor Cyan

if (-not (Get-Command git -ErrorAction SilentlyContinue)) {
    Write-Host "Git no está instalado. Descárgalo desde https://git-scm.com/download/win" -ForegroundColor Red
    exit 1
}

if (Test-Path ".git") {
    Write-Host "Esta carpeta ya contiene un repositorio Git. No se realizaron cambios." -ForegroundColor Yellow
    exit 1
}

git init
git add .
git commit -m "Estructura inicial de SIPU"
git branch -M master
git remote add origin "https://github.com/Elias1030/SIPU-Patitas-Unidas-Dgo.git"
git push -u origin master
git checkout -b develop
git push -u origin develop

Write-Host "Listo: se publicaron las ramas master y develop." -ForegroundColor Green
