# STEAM Dataminer Database JPA

Ez az alkalmazás a Steam Piac elemeit tárolja egy adatbázisban.

### Használt technológiák:
---
  - [Maven] - A projekt összeállításáért felelős felelős eszköz.
  - [JavaFX] - A megjelenítésért felelős keretrendszer.

### Telepítés
---
Letöltjük a projektet a Git segítségével:
```sh
git clone https://github.com/orotib/steam-dataminer-database-jpa.git
```
A telepítés a Maven segítségével történik. A projekt főkönyvtárában állva:
```sh
mvn clean install
```
Majd futtatjuk:
```sh
mvn exec:java@start-gui
```
Weblap legenerálása:
```sh
mvn clean site
```
Egyben mind:
```sh
mvn clean install site exec:java@start-gui
```

### Szoftveres követelmények
---
  - Apache Maven 3.3.9
  - [Oracle JDK 8]

### Verzió
---
  1.0

### License
----
[GNU GPLv3](http://www.gnu.org/licenses/gpl-3.0.html)

   [Maven]: <https://maven.apache.org/>
   [JavaFX]: <http://docs.oracle.com/javase/8/javase-clienttechnologies.htm>
   [Oracle JDK 8]: <http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html>
   [git-repo-url]: <https://github.com/orotib/steam-dataminer.git>