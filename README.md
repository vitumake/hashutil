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
import tel.kontra.util.HashUtilFactory;
import tel.kontra.util.HashAlgorithm;

// Create a HashUtil instance with a salt and algorithm
HashUtil hashUtil = HashUtilFactory.create("mySalt", HashAlgorithm.SHA_256);

// Hash a string
String hash = hashUtil.hash("my data");
System.out.println(hash);

// Verify a hash
boolean matches = hashUtil.verifyHash("my data", hash);
System.out.println("Match: " + matches);

// Truncate hash
String shortHash = hashUtil.hash("my data", 8);
System.out.println(shortHash);
```

## License

Apache License 2.0

## Author

Markus Vallin
