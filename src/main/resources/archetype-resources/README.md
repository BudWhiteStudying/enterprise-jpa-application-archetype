${camelApplicationName}
===

Questa applicazione è stata generata con
[Spring Enterprise JPA Application Archetype](http://gitlab.carige.web/development-general/java/maven-archetypes/spring-enterprise-jpa-application-archetype).

Struttura
---

${camelApplicationName} è un'applicazione Spring Boot multi-modulo, articolata sui seguenti moduli:

- `data` - contiene le interfacce DAO di Spring Data JPA

- `factory` - contiene le classi factory, responsabili della costruzione dei DTO; in termini
  generali, ogni DTO contenuto in `${package}.model.dto`, ad eccezione dei DTO di tipo
  `request` e `response`, deve essere costruito da un'apposita classe factory

- `feature` - destinato a contenere la logica di business dell'applicazione; ogni elemento
  funzionale *deve* risiedere in un package dedicato, come accade per le due feature
  esemplificative contenute nell'archetipo; ogni feature *deve* rispettare la suddivisione
  `controller`/`service`, come accade per le due feature esemplificative contenute nell'archetipo

- `framework` - contiene il codice trasversale alla logica di business (modalità di logging,
  eccezioni, messaggi pre-impostati); l'idea è quella di gestire queste tematiche in modo
  omogeneo tra le diverse applicazioni Dock (e.g. in maniera tale che ad una stessa casistica
  di errore possa corrispondere la stessa eccezione in tutte le applicazioni; o in maniera
  tale che tutte le applicazioni scrivano log allo stesso modo)

- `integration` - destinato a contenere la logica di iintegrazione con altre componenti
  applicative, ad esempio client SOAP; in fase di creazione è vuoto

- `model` - contiene i DTO ed eventualmente le entity gestite dall'applicazione; il modulo
  `model` viene esportato su Artifactory ad ogni build, in maniera tale che le applicazioni
  possano "condividere" i data model se necessario (e.g. se un'applicazione `A` invoca un
  servizio di un'applicazione `B` non deve scrivere degli appositi DTO per "scimmiottare"
  le response dell'applicazione `B`, ma può semplicemente importarne il modulo `model`)

- `war` - è il punto di partenza dell'applicazione, contiene la classe main e la
  relativa configurazione; in condizioni normali questo modulo non viene modificato
  rispetto a quanto generato in fase di creazione, perché la logica rilevante risiede
  tipicamente nei moduli "funzionali"; in fase di build, l'output di questo modulo è
  un archivio `.war`

- `ear` - modulo "di servizio", responsabile del packaging dell'applicazione in formato `.ear`

Unit test
---

Appena creata, ${camelApplicationName} ha un test coverage del 100%, ottenuto tramite

- la scrittura di unit test per le feature esemplificative che vengono generate insieme
  allo scheletro dell'applicazione (e.g. `${package}.feature.administration`)

- la definizione di pattern di esclusione dal calcolo del coverage (property `sonar.coverage.exclusions`
  nel parent-pom dell'applicazione).

Code analysis
---

Appena creata, ${camelApplicationName} è pronta per essere sottoposta a scansione
statica del codice sorgente, tramite SonarQube. Le property di dettaglio riferite
alll'integrazione con SonarQube sono contenute nel parent-pom dell'applicazione.