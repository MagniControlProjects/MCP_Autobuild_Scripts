pipeline{
    agent {
        label "${AGENT_LABEL}"
    }
    stages{
        stage ("Initialize Job"){
            steps{
                script{
                    
                    COMMON_UTILS_LOAD_LOCATION = "${WORKSPACE}/autobuild/CommonUtils/main.groovy"
                    echo ("CommonUtils at ${COMMON_UTILS_LOAD_LOCATION}")
                    Helper1 = load (COMMON_UTILS_LOAD_LOCATION).GenerateHelper()
                    
                }
            }
        }
        stage("Checkout Dependencies"){
            steps{
                script{
                    echo "Do Stuff"
                    Helper.test()
                }
            }
        }
        stage("Setup Build Folder"){
            steps{
                script{
                    echo "Do Stuff"
                }
            }
        }
        stage("Generate Version Info"){
            steps{
                script{
                    echo "Do Stuff"
                }
            }
        }
        stage("Do Building"){
            steps{
                script{
                    echo "Do Stuff"
                }
            }
        }
        stage("Store Artifacts"){
            steps{
                script{
                    echo "Do Stuff"
                }
            }
        }
    }
}