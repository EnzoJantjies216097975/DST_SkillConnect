@echo off
REM Clean the project
call gradlew clean

REM Delete the .gradle cache directory for KAPT
rmdir /s /q %USERPROFILE%\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin.kapt

REM Delete build directories
rmdir /s /q build
rmdir /s /q app\build

REM Invalidate caches
rmdir /s /q .idea\caches
rmdir /s /q .idea\libraries

echo KAPT caches cleaned. Now run gradlew build to rebuild the project.