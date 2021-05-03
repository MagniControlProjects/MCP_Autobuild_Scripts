pipeline{
    agent {
        label "${EXECUTE_ON_LABEL}"
    }
    stages{
        stage ("STAGE: Initialize Job and create "){
            steps{
                script{
                    COMMON_UTILS_LOAD_LOCATION = "${WORKSPACE}/autobuild/CommonUtils/helper.groovy"
                    echo ("CommonUtils at ${COMMON_UTILS_LOAD_LOCATION}")
                    HelperScript = load (COMMON_UTILS_LOAD_LOCATION)
                    Obj_Helper = HelperScript.GetHelperObject("${WORKSPACE}","${BUILD_ID}","${JOB_NAME}")
                    echo "Test1: Output to console from inside the pipeline.
                }
            }
        }
        stage("STAGE: "){
            steps{
                script{
                    "Test2: Output to console from inside the the Object."
                    Obj_Helper.testObjectToConsole()
                }
            }
        }
        stage("STAGE: Setup Build Folder"){
            steps{
                script{
                    echo "Do Stuff"
                    
                }
            }
        }
        stage("STAGE: Generate Version Info"){
            steps{
                script{
                    echo "Do Stuff"
                    echo "${Obj_Helper.testReturn()}"
                    
                }
            }
        }
        stage("STAGE: Do Building"){
            steps{
                script{
                    echo "Test Object Variable Pulling"
                    echo "${Obj_Helper.BuildId}"
                    echo "Do Stuff"
                }
            }
        }
        stage("STAGE: Store Artifacts"){
            steps{
                script{
                    echo "Do Stuff"
                }
            }
        }
    }
}