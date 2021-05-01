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
                    Obj_Helper = HelperScript.GetHelperObject()
                    
                }
            }
        }
        stage("Checkout Dependencies"){
            steps{
                script{
                    echo "Do Stuff"
                    Obj_Helper.initialize("${WORKSPACE}","${BUILD_ID}","${JOB_NAME}")
                }
            }
        }
        stage("Setup Build Folder"){
            steps{
                script{
                    echo "Do Stuff"
                    Obj_Helper.test()
                }
            }
        }
        stage("Generate Version Info"){
            steps{
                script{
                    echo "Do Stuff"
                    echo "${Obj_Helper.testReturn()}"
                    
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