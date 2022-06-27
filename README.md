#Spring Enterprise Application Archetype

Generating an archetype project from a multi-module project:
```
mvn archetype:create-from-project -Darchetype.properties=archetype.properties
```

Installing the archetype in the local repo
```
mvn clean install
```

Generating a project through the installed archetype
```
mvn archetype:generate -DarchetypeCatalog=local
```