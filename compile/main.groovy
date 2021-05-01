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
                    HelperScript = load (COMMON_UTILS_LOAD_LOCATION)
                    def Helper1 = HelperScript.HelperObject()
                    
                }
            }
        }
        stage("Checkout Dependencies"){
            steps{
                script{
                    echo "Do Stuff"
                    Helper.main()
                }
            }
        }
        stage("Setup Build Folder"){
            steps{
                script{
                    echo "Do Stuff"
                    Helper.test()
                }
            }
        }
        stage("Generate Version Info"){
            steps{
                script{
                    echo "Do Stuff"
                    Helper.testReturn()
                    
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