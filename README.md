# Álláskereső alkalmazás
## Futtatás:
- Futtatáshoz egy java IDE szükséges, illetve java 11.
## Bekonfigurálás:
- Klónozás után megnyitjuk a repositoryt majd a "mvn clean install" parancsot kiadjuk a project gyökerében.
- Ezután, pedig a jobSearchApplication.java nevű file main függvényét futtatjuk.
- Ha a szerver fut, akkor a localhost:8080 as porton keresztül elérjük az alkalmazást.
## Használat:
### Az oldalsó menüvel tudunk navigálni egyes oldalak között.
- Az alkalmazás kezdőoldala egy kliens felvivő felülelet, amelyen:
  - Fel tudunk vinni adatokat (email és név)
  - Ellenőrzi az alkalmazás az email cím helyes formátumát illetve az egyezést a már felvitt email címekkel.
    
- A következő oldal egy állás felvételét szolgáló oldal.
  - Fel tudunk vinni két mező segítségével állásokat.
  - Egy név és földrajzi hely alapján.
    
- A harmadik oldal egy állás keresésre használandó oldal.
  - Itt két mező alapján tudunk keresni.
  - Az első mezőben a név alapján. Itt a részleges tartalmazás is egyezést eredményez.
  - A második mező viszont, csak teljes egyezés alapján mutat eredményt, ez a mező nem kötelező. 