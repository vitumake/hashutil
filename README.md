# HashUtil Java Library

HashUtil is a Java library for hashing utilities and algorithms. It provides a simple interface for hashing data using various algorithms.

## Features
- Multiple hash algorithms
- Simple API
- Java 17 compatible

## Installation

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>tel.kontra</groupId>
    <artifactId>hashutil</artifactId>
    <version>1.0.0</version>
</dependency>
```

Or build locally:

```sh
mvn clean install
```

## Usage

```java
import tel.kontra.util.HashUtil;

String hash = HashUtil.hash("my data", "SHA-256");
System.out.println(hash);
```

## License
MIT

## Author
Your Name
