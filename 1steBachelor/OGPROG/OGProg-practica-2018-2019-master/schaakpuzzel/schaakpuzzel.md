Schaakpuzzel
============

Je hebt voor deze oefening vier java-bestanden nodig, namelijk:

* [Schaakpuzzel.java](src/Schaakpuzzel.java),
* [Lijnenlezer.java](src/Lijnenlezer.java),
* [Bord.java](src/Bord.java) en
* [Stuk.java](src/Stuk.java).

Deze vier klassen vormen een werkend programma dat je vanop de opdrachtlijn kan uitvoeren.
Het programma simuleert een eenvoudige schaakpuzzel: je plaatst stukken op een schaakbord en de bedoeling is om dit zo lang mogelijk vol te houden zonder dat één van de stukken een ander stuk bedreigt.

Om een schaakstuk te plaatsen, gebruik je een code van drie letters. De eerste letter bepaalt het type van het stuk (P: paard, L: loper, T: toren, D: dame), de tweede letter de kolom (van a tot h), de derde het rijnummer (1 tot 8).

## Doel van deze oefening

Hoewel het programma al vier verschillende klassen bevat, is het ontwerp ervan niet zeer objectgeoriënteerd.
De uiteindelijke bedoeling van deze oefening is om het programma zodanig aan te passen dat het zo goed mogelijk voldoet aan de '*regels van de kunst*'.

(En we hopen natuurlijk dat je die dan ook toepast in al je toekomstige programma's.)

## Opgave

Voer deze opgave stap voor stap uit en **test** telkens tussen elke stap of het programma nog steeds werkt.
Onderdruk de neiging om meerdere stappen tegelijk te doen.

**Stap 1.** Maak een nieuw IntelliJ-project aan van het type *Java* (dus *niet* JavaFX) met als Project SDK 11.
Geef `Schaakpuzzel` op als *Project name* en laat het *Base package* veld leeg.
Klik dan op *Finish* om IntelliJ het project daadwerkelijk aan te laten maken.
Stel het *Language level* van het project in op Java 11. Deze instelling kan je vinden in het *Project Structure...* venster, bij *Project Settings*, *Project*.

Kopieer dan de vier bovengegeven Java klassen naar de `src` map van het net aangemaakte project en probeer het programma eens uit te voeren.
Zorg ervoor dat je goed begrijpt wat het programma doet en bestudeer even de programmacode.

**Stap 2.** IntelliJ houdt er eigenlijk niet van dat je geen *packages* (pakketten) gebruikt.
Plaats daarom je programma in het pakket `schaakpuzzel`.
Dit kan gedaan worden door een nieuw *package* aan te maken met de naam `schaakpuzzel` (rechtsklikken op de *src* map > *new* > *package*).
Selecteer dan de vier Java klassen en verplaats ze naar de nieuwe `schaakpuzzel` *package*.
IntelliJ zal nu de bestanden verplaatsen en de klassen *refactoren*.
Wat verandert er hierdoor aan de broncode?

(Paragraaf 2.1 van de [zelfstudienota's](http://inigem.ugent.be/jvlfx/jvlfx.pdf) bevat wat bijkomende informatie 
over wat een _package_ is.) 

**Stap 3.** De schaakpuzzel gebruikt verschillende soorten schaakstukken die elk een ander gedrag vertonen.
Je hebt dus wellicht al door dat elk stuk best als een object van een andere klasse kan worden voorgesteld.

Vorm het programma zodanig om dat het nu vier verschillende klassen gebruikt: `Paard`, `Toren`, `Loper` en `Dame`.
Opdat de klasse `Bord` zonder veel verandering zou kunnen gebruikt worden, zal ook `Stuk` nog moeten blijven bestaan (maar met grondige wijzigingen).
Denk eerst goed na over je nieuwe klassenstructuur, vooraleer je de nodige wijzigingen aanbrengt.

Tip: het belangrijkste verschil tussen de vier stukken is de manier waarop ze velden van het schaakbord bedreigen.
Door een goeie programmastructuur kan je de samengestelde `if/else-if`-opdracht in methode `stukBedreigtPositie` van `Bord` vermijden, en uiteindelijk misschien zelfs de volledige methode laten wegvallen. (Zie ook hoofdstuk 2 van de cursusnota's.)

**Stap 4.** Ook de `if/else-if`-opdracht in methode `letterVoorStuk` van `Bord` kan worden vereenvoudigd of zelfs weggelaten: je kan er bijvoorbeeld voor zorgen dat elk stuk zijn eigen code kent.

Ondertussen zal je misschien ook merken dat `Paard`, `Toren`, `Loper` en `Dame` heel wat gemeenschappelijke code bevatten.
Kan je die niet naar een andere klasse overhevelen? (En desnoods hiervoor speciaal een nieuwe klasse aanmaken?)

**Stap 5.** Een goed programmaontwerp laat ook gemakkelijk toe dat je het programma uitbreidt met nieuwe elementen.
Voeg een nieuw stuk toe, een Amazone, die dezelfde velden bedreigt als de combinatie van een paard en een dame.

Heb je veel moeten veranderen?
Had je je ontwerp nog kunnen aanpassen, zodat je nog minder zou moeten veranderen?
Doe dit dan nu, want straks voegen we misschien nog een Kangoeroe toe.

**Stap 6.** Er is nog een kleinigheidje waarmee we ons programma nog iets meer objectgeoriënteerd kunnen maken. In `decodeerLijn` van `SchaakPuzzel` staat er nog een `if/else-if`-opdracht die je kan vermijden.
Vervang die door gebruik te maken van een hash-map van *factories* voor schaakstukken.
(Factories hebben we onder andere reeds gebruikt in de *Snake*-oefening van het vak *Programmeren*.)
