Vier Op Een Rij
===============

Voor deze oefening heb je de Java-bestanden nodig uit het
zip-bestand [vieropreenij-src.zip](vieropeenrij-src.zip?raw=true).
Hiermee kan je een programma maken voor het spel '[Vier op een rij](http://nl.wikipedia.org/wiki/Vier_op_%27n_rij)'.

De gebruikersinterface werkt al voor een groot deel, je moet wel nog de 'spelregels' implementeren. Volg hierbij 
het onderstaande stappenplan.

## Stap 1. Werken met IntelliJ

Zorg eerst dat het programma werkt in een IntelliJ-omgeving,
zonder iets aan de code te wijzigen. Enkele tips:

* Dit is een *JavaFX*-programma. Het begin van hoofdstuk 2 uit de [zelfstudienota's](http://inigem.ugent.be/jvlfx/jvlfx.pdf) 
beschrijft wat je allemaal moet doen om een nieuw JavaFX-project aan te maken in IntelliJ IDEA.
* Geef het IntelliJ-project de naam `VierOpEenRij`.
* Alle klassen bevinden zich in het pakket (de _package_) `vieroprij`.
* IntelliJ gebruikt een _language level_ dat standaard staat ingesteld op Java 6.
Die moet Java **11** worden. Zie _File_ > _Project Structure_.

### Tip bij het gebruik van de PCs in de PC-klas:
Door overbelasting van de centrale fileservers is het handiger en sneller
om IntelliJ-projecten op de lokale harde schijf (de `C:` schijf) te plaatsen,
in plaats van op de netwerk-drive.
Vergeet echter niet om op het einde van het practicum
je werk naar de netwerk-schijf te kopiëren, anders raakt het verloren
als je uitlogt.

Eigenlijk raden we je **ten zeerste** aan om je **eigen computer** te gebruiken.


## Stap 2. Code aanpassen
Het programma zoals het er nu uitziet, doet nog niet helemaal wat je
ervan zou verwachten. Zo komt bijvoorbeeld 
een tweede schijfje in dezelfde kolom niet op de juiste plaats terecht.

**Opgave**: vul de code aan in de klasse `Model` zodanig dat
het programma doet wat je ervan verwacht:
de schijfjes stapelen zich in het blauwe raster naar boven toe op,
en er kan geen schijfje meer in een kolom vallen die al vol zit.

We geven een korte beschrijving van de verschillende methoden
die je in deze stap moet implementeren
(de andere methoden zijn voor de volgende stap):

* De methode `playableMove` wordt telkens
opgeroepen wanneer het programma wil weten of
er in een bepaalde kolom nog een schijf kan worden geplaatst.
Zorg dat deze methode hiervoor telkens de juiste waarde
(`true` of `false`) teruggeeft.
* De methode `moveDestination` wordt 
opgeroepen vooraleer er een schijf in een bepaald kolom wordt gegooid.
De waarde je moet teruggeven is het correcte rijnummer,
startend vanaf 0, geteld van boven naar onder.
* De methode `playMove` wordt opgeroepen vlak nadat
ter een schijf in de opgegeven kolom werd gegooid.

Merk op dat `playableMove` en `moveDestination` ook meer dan één
keer kunnen worden opgeroepen voor dezelfde spelsituatie en dezelfde kolom.
Met andere worden, deze methoden mogen geen 'effect' hebben, en alleen een waarde teruggeven. 
De methode `playMove` wordt
daarentegen slechts één keer opgeroepen voor een bepaalde zet.

Het is goed mogelijk dat je aan de klasse `Model` ook enkele
velden (variabelen) moet toevoegen en bijkomende methoden.

**Belangrijk**: Los deze (en volgende) stap op zonder ook maar één
letter code te veranderen in één van de andere klassen!

## Stap 3. Vier op een rij.
In deze stap moet je ervoor zorgen dat het programma herkent
wanneer er zich vier schijven van dezelfde kleur op een
rij bevinden (horizontaal, verticaal of diagonaal).
Dit doe je in de methode `checkGameOver`.

Deze methode werk echter anders dan de methodes uit de vorige stap.
Het is een procedure en geen functie.
Je moet dus niet alleen nagaan of er zich een 'vier op een rij' voordoet,
maar in dat geval ook de andere delen van het programma op de hoogte
brengen dat het spel ten einde loopt.
Dit doe je door de luisteraars die bij het model zijn geregistreerd, te verwittigen.
Dit gebeurt met behulp van de reeds gegeven methode `notifyListeners`.

(De kunst is om je niet af te vragen wie die luisteraars dan wel mogen zijn...)

Vergeet ook niet om de methode `checkGameOver` zelf op het juiste moment op te roepen.

**Belangrijk**: Los dit op zonder ook maar één letter code te veranderen in één 
van de andere klassen!

## Waarschuwing
De broncode van dit programma is gedeeltelijk van het internet geplukt
en is (bijgevolg) niet altijd een goed voorbeeld van hoe je een dergelijk programma schrijft.

Deze oefening illustreert enkele belangrijke basisprincipes van het programmeren
van grafische gebruikersinterfaces - in het bijzonder de scheiding van _model_
en _user interface_ en het gebruik van _luisteraars_ om op gebeurtenissen te reageren. Deze principes zullen later
 in de lessen uitvoerig worden behandeld.

Het is normaal dat je de werking van het programma
nog niet voor de volle 100% begrijpt - dat hoeft ook niet, zolang je je maar aan bovenstaande instructies houdt. 
Bij het schrijven van professionele software is het meestal zo dat een programmeur enkel zijn eigen 
kleine onderdeeltje hoeft te begrijpen en de manier waarop het met de rest van het programma interageert. 




