# mitum-keypair-java

This is a package to generate key pairs used in __mitum__ and __mitum2__.

## Installation

### Environment

The `latest` branch is being updated in the following environments:

```sh
$ gradle --version

------------------------------------------------------------
Gradle 7.6
------------------------------------------------------------

Build time:   2022-11-25 13:35:10 UTC
Revision:     daece9dbc5b79370cc8e4fd6fe4b2cd400e150a8

Kotlin:       1.7.10
Groovy:       3.0.13
Ant:          Apache Ant(TM) version 1.10.11 compiled on July 10 2021
JVM:          19.0.1 (Oracle Corporation 19.0.1+10-21)
OS:           Mac OS X 12.0.1 aarch64

$ java --version
java 19.0.1 2022-10-18
Java(TM) SE Runtime Environment (build 19.0.1+10-21)
Java HotSpot(TM) 64-Bit Server VM (build 19.0.1+10-21, mixed mode, sharing)

$ javac --version
javac 19.0.1
```

Check different branches for compatible code with different versions of Java.

### Gradle

Insert the following code into your `build.gradle`.

```groovy
dependencies {
    // other dependencies
    implementaion files("${your_file_ path}/mitum-keypair-${pkg-ver}-${jdk-ver}.jar")
}
```

Check all versions of jar files [here](./release).

## Test

Run the following command to test the package:

```sh
$ gradle test

BUILD SUCCESSFUL in 336ms
3 actionable tasks: 3 up-to-date
```

## Run

### Generate mitum1 KeyPair

```java
package xx;

import mitum.keypair.*;

public class App {
    public static void main(String args[]) {
        // random keypair
        M1KeyPair kp1 = M1KeyPair.random();
        
        // keypair from string private key
        String pks = "L39Fcnf2arMoxBrrW8miPLgnZ81mfAKm3Gd1mtdCM7MmGYrRSBVxmpr";
        M1KeyPair kp2 = M1KeyPair.from(pks);

        // keypair from m1 private key
        M1PrivateKey pk = M1PrivateKey.from(pks);
        M1KeyPair kp3 = M1KeyPair.from(pk);

        // keypair from string/byte[] seed
        String seed = "Monsters Insult Allergic Magazines Since Dreamy Killer Farces Juggle Apparent Dark Knights";
        M1KeyPair kp4 = M1KeyPair.fromSeed(seed);
        M1KeyPair kp5 = M1KeyPair.fromSeed(seed.getBytes());

        String privateKey = kp1.getPrivateKey().toString(); // get private key
        String publicKey = kp1.getPublicKey().toString(); // get public key
    }
}
```

### Generate mitum2 KeyPair

```java
package xx;

import mitum.keypair.*;

public class App {
    public static void main(String args[]) {
        // random keypair
        M2KeyPair kp1 = M2KeyPair.random();
        
        // keypair from string private key
        String pks = "F1wL8DkcP4mjCUWB9kRbzRZos4HPVy4Fb5XMQ1zWwnxhmpr";
        M2KeyPair kp2 = M2KeyPair.from(pks);

        // keypair from m2 private key
        M2PrivateKey pk = M2PrivateKey.from(pks);
        M2KeyPair kp3 = M2KeyPair.from(pk);

        // keypair from string/byte[] seed
        String seed = "Monsters Insult Allergic Magazines Since Dreamy Killer Farces Juggle Apparent Dark Knights";
        M2KeyPair kp4 = M2KeyPair.fromSeed(seed);
        M2KeyPair kp5 = M2KeyPair.fromSeed(seed.getBytes());

        String privateKey = kp1.getPrivateKey().toString(); // get private key
        String publicKey = kp1.getPublicKey().toString(); // get public key
    }
}
```

### Sign with KeyPair

```java
package xx;

import mitum.keypair.*;

public class App {
    public static void main(String args[]) {
        String msg = "this is the message to sign";

        // string private keys
        String spk1 = "";
        String spk2 = "";

        // private keys
        M1PrivateKey pk1 = M1PrivateKey.from(pk1);
        M2PrivateKey pk2 = M2PrivateKey.from(pk2);

        // keypairs
        M1KeyPair kp1 = M1KeyPair.random();
        M2KeyPair kp2 = M2KeyPair.random();
    
        // sign with private key
        byte[] sig1 = pk1.sign(msg); // or use msg.getBytes();
        byte[] sig2 = pk2.sign(msg);
        byte[] sig3 = kp1.sign(msg);
        byte[] sig4 = kp2.sign(msg);
    }
}
```

Encodes all signatures into base58 when transferring to the mitum network.