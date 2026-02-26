pipeline {
 agent any

 stages {

  stage('Build') {
   steps {
    sh '''
    mkdir -p build
    javac -d build src/*.java
    '''
   }
  }

  stage('Test') {
   steps {
    sh '''
    if [ ! -f junit.jar ]; then
     curl -L -o junit.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/junit-platform-console-standalone-1.10.0.jar
    fi

    mkdir -p test-build
    javac -cp junit.jar:build -d test-build test/*.java

    java -jar junit.jar \
    --class-path build:test-build \
    --scan-class-path
    '''
   }
  }

  stage('Deploy') {
   steps {
    sh '''
    jar cf PasswordChecker.jar -C build .
    '''
   }
  }

 }

 post {
  success {
   echo "Security Tool Built Successfully 🔐"
  }
 }
}
