@echo off
echo Copying file...

REM Source file
set source="D:\eclipse-workspace\ores-to-the-nether-1.20.1\build\libs\ores-to-the-nether-1.0.0.jar"

REM Destination directory
set destination="D:\Modrinth App\com.modrinth.theseus\profiles\Fabulously Optimized\mods"

REM Copying the file
copy %source% %destination%
