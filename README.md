# device-simulator
## How to run tests with JUnit
### macOS
Install OpenJDK 17 and create a soft link of it

```bash
brew install openjdk@17
sudo ln -sfn $HOMEBREW_PREFIX/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk
```

Install Maven

```bash
brew install maven
```

Move to the project directory and build the project

```bash
mvn install
```

Run tests

```bash
mvn test
```

### Debian-based distributions
Install OpenJDK 17 and Maven

```bash
sudo apt install openjdk-17-jdk
sudo apt install maven
```

Add `JAVA_HOME` by writing the following command to `~/.bashrc`

```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
```

Execute `~/.bashrc`

```bash
source ~/.bashrc
```

Move to the project directory and build the project

```bash
mvn install
```

Run tests

```bash
mvn test
```
