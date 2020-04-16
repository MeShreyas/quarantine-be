# Self Assessment Backend

Self Assessment is the backend for the self assessment dashboard. It talks to both POSTGRES to fetch the data then pushes the data to Elastic Search.
This happens every hour 

## Installation

Install maven and java 8 for the build

```bash
mvn clean install -DskipTests
```

This will create a snapshot jar in the target folder.

## Usage

```bash
java -jar self_assesment-0.0.1-SNAPSHOT.jar
```