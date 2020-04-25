Prog2
=====

Voorbeeldprogramma's voor het vak Objectgericht Programmeren uit 1e bachelor Informatica

Dit is een IntelliJ Idea project.

Behalve de broncode (in `src`) bevat dit project ook een script waarmee 
een databank kan worden opgezet en ingevuld. Zie `etc/Readme.md`.

### Benodigde software

* Je hebt Java 11, JavaFX 11 en de Scene Builder nodig om de voorbeelden te kunnen compileren en uitvoeren. 
Installatie-instructies vind je in hoofdstuk van [dit document](https://inigem.ugent.be/jvlfx/jvlfx.pdf).
* Als programmeeromgeving raden we IntelliJ IDEA aan. De *Community Edition* volstaat, maar studenten kunnen ook 
gratisch de *Ultimate Edition* downloaden. Installatie- en configuratieinstructies vind je opnieuw in
bovenstaand document.
* Je hebt een JDBC Driver nodig voor SQLite. Zie 
[https://bitbucket.org/xerial/sqlite-jdbc](https://bitbucket.org/xerial/sqlite-jdbc).
* Je hebt *Apache Derby* nodig (JDBC drivers én databank server). Onder Ubuntu/Debian Linux
kan je die installeren met `apt install derby-tools`, voor andere besturingssystemen verwijzen we naar 
[de website](http://db.apache.org/derby/derby_downloads.html). Je hebt ook een driver nodig voor *SQLite* en de JDOM2
bibliotheek - zie onderaan.

Installeren van de databanksoftware alleen is niet voldoende. Je moet de JDBC-drivers bij IntelliJ IDEA registreren
en de databank zelf ook nog aanmaken (zie [etc/Readme.md](etc/Readme.md)). 

### Bijkomende bibliotheken installeren

De gemakkelijkste manier om de drie bijkomende bibliotheken te installeren
is door gebruik te maken van de *Maven*-ondersteuning van IntelliJ IDEA.

* Ga naar *Project Structure* en kies *Libraries*.
* Klik op de + bovenaan en selecteer *From Maven...*
* In het venster dat nu verschijnt, vink je *Download to* aan!
* Bovenaan in het veld tik je het volgende in. En je drukt daarna op OK.

        org.apache.derby:derbyclient:10.14.2.0
    
* Doe daarna hetzelfde voor deze twee bibliotheken:

        org.xerial:sqlite-jdbc:3.25.2
        org.jdom:jdom2:2.0.6

    



