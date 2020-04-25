@REM Start de Derby server voor gebruik in Programmeren 2

@REM Volgende twee variabelen moeten correct zijn ingesteld (zonder \ op het einde)
@REM Installatiemap van java
set JAVA_HOME=C:\Program Files\jdk-11.0.1+13

@REM Basismap waarin Derby jouw databankbestanden zal bewaren
set DERBY_SYSTEM_HOME=c:\Derby

@REM Map waarin de Derby-installatie zich bevindt
set DERBY_HOME=C:\Program Files\db-derby-10.14.2.0-bin

set DERBY_OPTS=-Dderby.system.home=%DERBY_SYSTEM_HOME%
start "" "%DERBY_HOME%\bin\startNetworkServer.bat" -p 45270
