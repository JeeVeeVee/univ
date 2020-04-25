@REM Client die connecteert met Derby.
@REM oproepen met: derby.bat [database]

@REM Volgende drie variabelen moeten correct zijn ingesteld (zonder \ op het einde)
@REM Installatiemap van java
set JAVA_HOME=C:\Program Files\jdk-11.0.1+13

@REM Basismap waarin Derby jouw databankbestanden zal bewaren
set DERBY_SYSTEM_HOME=c:\Derby

@REM Map waarin de Derby-installatie zich bevindt
set DERBY_HOME=C:\Program Files\db-derby-10.14.2.0-bin

set DATABASE=%1
if ""%1""="""" set DATABASE=prog2

set DERBY_OPTS=-Dderby.system.home=%DERBY_SYSTEM_HOME% -Dij.user=prog2 -Dij.password=sesamopenu -Dij.protocol=jdbc:derby: -Dij.database=%DATABASE%";create=true"
"%DERBY_HOME%\bin\ij.bat"
