# VedantuAssignment

## how to setup

install maven on Windows:
- navigate to Apache Maven Site: https://maven.apache.org/download.cgi
- download the latest version and select the Maven zip file, for example, apache-maven-3.8.4-bin.zip
- add both M2_HOME and MAVEN_HOME variables to the Windows environment using system properties and point it to our Maven folder
- update the PATH variable by appending the Maven bin folder — %M2_HOME%\bin
- verify maven installation by running mvn -version on command line

install maven on Linux:
- navigate to Apache Maven Site: https://maven.apache.org/download.cgi
- download the latest version and select the Maven zip file, for example, apache-maven-3.8.4-tar.gz
- extract the archive using following command:
  tar -xvf apache-maven-3.3.9-bin.tar.gz -C /usr/local/apache-maven/apache-maven-3.8.4
- add Maven to environment path
  nano ~/.bashrc
  export M2_HOME=/usr/local/apache-maven/apache-maven-3.8.4
  export M2=$M2_HOME/bin
  export MAVEN_OPTS=-Xms256m -Xmx512m
  export PATH=$M2:$PATH
- reload the environment configuration
  source ~/.bashrc
- verify maven installation by running mvn -version on command line


## setting up selenium webdriver

check your chrome's version by

`google-chrome --version`

download appropriate webdriver from follwing link

`https://sites.google.com/a/chromium.org/chromedriver/downloads`

extract it to project's ChromeDriver folder 

## how to run test

`javac BookingReservationCukeRunner.java`

or 

`mvn test` from command prompt

### Assumptions
`java1.8 is installed`
