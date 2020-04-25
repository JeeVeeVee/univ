@REM Start de Derby server voor gebruik in Programmeren 2

@REM Volgende variabele moet correct zijn ingesteld (zonder \ op het einde)
@REM Installatiemap van java
set JAVA_HOME=C:\Program Files\jdk-11.0.1+13

@REM Map waarin de Derby-installatie zich bevindt
set DERBY_HOME=C:\Program Files\db-derby-10.14.2.0-bin

"%DERBY_HOME%\bin\stopNetworkServer.bat" -p 45270

