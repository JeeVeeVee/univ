Opzetten databanken / installeren drivers / opdrachtlijn
=========================

Databankscripts
---------------
Deze map bevat drie scripts die het gebruik van de Derby-databanken uit dit vak moet gemakkelijker maken.
Er zijn versies voor UNIX (en MAC OS/X) en voor Windows (de .bat-bestanden). Ze moeten uitgevoerd worden vanop de
opdrachtlijn.

* `startDerby` start de database server op. De server moet draaien vooraleer je er met een javaprogramma
  mee kunt communiceren
* `stopDerby` stopt de database server
* `derby prog2` connecteert rechtstreeks met de `prog2` databank
* `derby contacts` connecteert rechtstreeks met de `contacts` databank
(In Windows gebruik je in de plaats `startDerby.bat`, `stopDerby.bat` en `derby.bat`.)

Vooraleer je de scripts voor de eerste keer gebruikt moet je er enkele variabelen in aanpassen (zie scripts).
 
* `JAVA_HOME` moet verwijzen naar de map waarin je Java 11 hebt geïnstalleerd.
* `DERBY_SYSTEM_HOME` moet verwijzen naar de map waar (je wil dat) de databankbestanden worden opgeslagen.
* `DERBY_HOME` moet verwijzen naar de map waarin de Derby-scripts `ij` en `NetworkServerController` zich 
bevinden. (Ubuntu/Debian Linux: `/usr/share/derby`.)
 
Aanmaken / opvullen
-------------------
Deze map bevat ook drie SQL-scripts `students.sql`, `contacts.sql`, `proglangs.sql`  waarmee je de databanken kunt aanmaken
en opvullen met gegevens. Dit doe je op de volgende manier vanop de opdrachtlijn:

    derby contacts < contacts.sql
    derby prog2 < students.sql
    derby prog2 < proglangs.sql

Veiligheidsrestricties van Java
-------------------------------
Omdat de security-regels zijn versterkt bij de laatste versies van Java, kunnen we de Derby database server 
niet zonder meer gebruiken zoals je in sommige voorbeelden op het Internet ziet. De reden is dat een gewone 
gebruiker nu niet langer de toelating heeft om Derby op te starten met zijn standaardnetwerkpoort.

Er zijn twee manieren om dit op te lossen.
* De veiligheidsregels afzwakken - maar dat gaan we niet doen
* Een andere netwerkpoort gebruiken voor Derby die wel voor een gewone gebruiker is toegelaten, meer bepaald
  poort nummer 42570 in plaats van 1527.

In de praktijk betekent dit dat we de databankserver bij het opstarten met dit poortnummer zullen configureren (dit
gebeurt al in bovenstaande scripts) en dat we de volgende JDBC-URL zullen gebruiken in de Java-programma's
die met de databankserver communiceren (dit is reeds zo in alle voorbeeldprogramma's)

    jdbc:derby://localhost:45270/databasenaam

Drivers installeren in IDEA
---------------------------
Zie [README.md (bijkomende bibliotheken installeren)](../README.md) in de hoofdmap van dit project.

Uitvoeren van een JavaFX-programma vanop de opdrachtlijn
-----
Omdat JavaFX (Java 11-)modules gebruikt, moet je heel wat
parameters doorgeven aan de java virtuele machine om een
JavaFX-programma op te starten. (Je ziet dit bijvoorbeeld in het
Run-venster wanneer je een JavaFX-programma uitvoert vanuit IntelliJ
IDEA.)

Deze map bevat een Linux-script `javafx` die je daarbij kan
helpen. (Windows-gebruiker kunnen zich hierdoor laten inspireren.) In
de eerste lijn van dit script moet je map aangeven waar de
JavaFX-bibliotheken zich bevinden - dezelfde map die je ook gebruikt
hebt om in IntelliJ IDEA de *global library* `JavaFX` aan te maken.

Daarna kan je de opdracht `javafx` gebruiken zoals je elders `java` gebruikt

    $ javafx -jar prog2.jar
    $ javafx prog2.students.ShowMarksMain
    
(Dit laatste met het *class path* als *current directory*.)
    


