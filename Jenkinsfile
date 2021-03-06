pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
		disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
    gradle 'Gradle4.5_Centos' //Preinstalada en la Configuración del Master
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
		steps{
      	// Conexión al repositorio
        echo "------------>Checkout<------------"
        checkout([
    			$class: 'GitSCM', 
    			branches: [[name: '*/main']], 
    			doGenerateSubmoduleConfigurations: false, 
    			extensions: [], 
    			gitTool: 'Default', 
    			submoduleCfg: [], 
    			userRemoteConfigs: [[
    				credentialsId: 'GitHub_danielfms', 
    				url:'https://github.com/danielfms/Reservas-Ceiba.git'
    			]]
    		])
		}
    }
    
    stage('Compile & Unit Tests') {
		steps{
        echo "------------>Unit Tests<------------"
		sh 'chmod +x ./reservas-backend/microservicio/gradlew'
		sh './reservas-backend/microservicio/gradlew --b ./reservas-backend/microservicio/build.gradle test'
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
		sh 'chmod +x ./reservas-backend/microservicio/gradlew'
        sh './reservas-backend/microservicio/gradlew --b ./reservas-backend/microservicio/build.gradle build -x test'
      }
    }


    stage('Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
		sh 'chmod +x ./reservas-backend/microservicio/gradlew'
		sh './reservas-backend/microservicio/gradlew --b ./reservas-backend/microservicio/build.gradle clean'
        sh './reservas-backend/microservicio/gradlew --b ./reservas-backend/microservicio/build.gradle test'
        sh './reservas-backend/microservicio/gradlew --b ./reservas-backend/microservicio/build.gradle jacocoTestReport'
      }
    }


    stage('Static Code Analysis') {
      steps{
        echo '------------>Static code analysis<------------'
        withSonarQubeEnv('Sonar') {
          sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
        }
      }
    }
  }
  
post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      mail (to: 'daniel.marin@ceiba.com.co',subject: "SUCCESS Pipeline:${currentBuild.fullDisplayName}",body: "Hi Ceiba <3")
      junit '**/test-results/test/*.xml'

    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'daniel.marin@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
