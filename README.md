# Álláskereső alkalmazás
Ez egy állaskereső alkalmazás, amelyben klienseket és állásokat tudunk felvinni egy inmemory adatbázisba és keresni tudunk a már felvitt állások között.
## Futtatás:
- Futtatáshoz egy java IDE szükséges, illetve telepített java 11.
## Bekonfigurálás:
- Klónozás után megnyitjuk a repositoryt majd a "mvn clean install" parancsot kiadjuk a project gyökerében.
- Ezután, pedig a jobSearchApplication.java nevű file main függvényét futtatjuk.
- Ha a szerver fut, akkor a localhost:8080 as porton keresztül elérjük az alkalmazást.
- Kelleni fog még egy webböngésző, ennek címsorába beírjuk a locahost:8080 stringet és már szemünk elé is tárul a felhasználói felület
## Használat:
### Az oldalsó menüvel tudunk navigálni egyes oldalak között.
- Az alkalmazás kezdőoldala egy kliens felvivő felülelet, amelyen:
  - Fel tudunk vinni adatokat (email és név)
  - Ellenőrzi az alkalmazás az email cím helyes formátumát, illetve az egyezést a már felvitt email címekkel.
  - A beviteli mezők alatt található az eddig összes felvitt kliens.
    
- A következő oldal egy állás felvételét szolgáló oldal.
  - Fel tudunk vinni két mező segítségével állásokat.
  - Egy név és földrajzi hely alapján.
  -  A beviteli mezők alatt található az eddig összes felvitt pozíció.
    
- A harmadik oldal egy állás keresésre használandó oldal.
  - Itt két mező alapján tudunk keresni.
  - Az első mezőben a név alapján. Itt a részleges tartalmazás is egyezést eredményez, ez a mező nem kötelező.
  - A második mező, részletes egyezés alapján is mutat eredményt, ez a mező nem kötelező. 


## Fejlesztési lehetőségek:
- Az alkalmazást számos módon lehetne továbbfejleszteni a jövőben, ilyen pélául:
  - Egy igazi adatbázist mögé rakni, hogy egy újratöltés/megnyitás után ne vesszenek el a felvitt adatok
  - Több funkció, bejelentkezés, ezzel együtt session kezelés megvalósítása
  - Az állások elmentése, nem csak név alapján keresés
  - Egy szebb, felhasználóbarátabb gui elkészítése
