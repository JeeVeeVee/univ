Mailboxconversie
----------------

In deze oefening passen we Java-invoer- en uitvoer toe in de
praktijk. Codevoorbeelden uit die les kan je terugvinden op Github: bij 
[package prog2.nio](https://github.ugent.be/kcoolsae/Prog2/tree/master/src/prog2/nio)
en bij
[package prog2.io](https://github.ugent.be/kcoolsae/Prog2/tree/master/src/prog2/io).

Een mailbox is een bestand met e-mailberichten
waarbij elk bericht aan een precies gedefinieerd formaat voldoet.
Dit stelt een e-mailleesprogramma in staat om de afzonderlijke berichten
van elkaar te onderscheiden.
In deze oefening schrijven we een Javaprogramma om een mailboxbestand
te converteren naar HTML.

Je kan de oefening uitproberen op het volgende mailboxbestand:

* [mailbox.txt](mailbox.txt)

Het eerste bericht in dit bestand ziet er zo uit:
```
From: Sawyer Peterson <Sawyer.Peterson@wilkes.edu>
Date: Mon Sep  1 15:30:03 CEST 2014
Subject: Thus spake the

Thus spake the master programmer:
        "A well-written program is its own heaven; a poorly-written program
is its own hell."
                -- Geoffrey James, "The Tao of Programming"
```

De hoofding van deze e-mail bestaat uit drie velden:

* Een `From:` veld met daarin het e-mailadres van de afzender.
* Een `Date:` veld met de datum waarop het bericht verstuurd is.
* Een `Subject:` veld met de titel van het bericht.

Dan volgt een lege regel, gevolgd door de inhoud van het bericht.
Een volgend bericht begint weer met een `From:` veld aan het begin van een nieuwe regel.

We schrijven een Javaprogramma dat dit soort mailboxbestanden omzet naar HTML.
Daarbij scheiden we de berichten van elkaar met een `<hr>`-tag.
De drie velden `From:`, `Date:` en `Subject:` in een bericht
zetten we in vetjes (met `<strong>`-tags).
Deze drie regels eindigen we alledrie met een `<br>`-tag
opdat ze in HTML op een afzonderlijke regel worden weergegeven.
Elke paragraaf in de inhoud van het bericht krijgt
zijn eigen paragraaf in HTML door middel van `<p>` tags.

Het resultaat van deze omzetting schrijven we weg naar een nieuw HTML-bestand.
We verifiëren de correctheid van het Javaprogramma door dit bestand te openen
in een webbrowser. Dat moet er uit zien zoals in dit [voorbeeld](mailboxhtml.png).

De gebruiker moet het programma op verschillende manieren 
kunnen aanroepen, afhankelijk van de opdrachtlijnargumenten
die zijn meegegeven aan de `main` methode.
(`public static void main(String[] args) { ... }`)

Wij verwachten steeds twee argumenten. Het eerste duidt de invoer aan,
het tweede de uitvoer.

Het eerste argument heeft aan waar we de invoer vandaan moeten halen:
* Als dit begint met `http://` of `https://`,
dan moet het invoerbestand van het internet gelezen worden. (Gebruik hiervoor de Javaklasse `URL`.)
* Als dit gelijk is aan een minteken "-", dan moeten we
de mailbox inlezen van het standaard invoerkanaal.
* En anders is het argument de naam van een bestand op de computer.

Het tweede argument specificeert de wijze van uitvoer:

* Als dit gelijk is aan een minteken "-", dan betekent dit
dat wij de HTML moeten schrijven naar het standaard uitvoerkanaal.
* En anders is dit de naam van het bestand waarnaar de HTML moet worden uitgeschreven.
