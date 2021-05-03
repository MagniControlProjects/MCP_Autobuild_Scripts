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
                    Obj_Helper = HelperScript.GetHelperObject("${WORKSPACE}","${BUILD_ID}","${JOB_NAME}",echo)
                    echo "Test1: Output to console from inside the pipeline."
                }
            }
        }
        stage("STAGE: Print To console from inside Object"){
            steps{
                script{
                    echo "Test2: Output to console from inside the the Object."
                    Obj_Helper.testObjectToConsole()
                }
            }
        }
        stage("STAGE: Print to console from variable returned from object"){
            steps{
                script{
                    echo "Test3: Output to console with variable returned from object."
                    returnVal = Obj_Helper.testReturn()
                    echo "${returnVal}"
                    
                }
            }
        }
        stage("STAGE: Print Properties of the object"){
            steps{
                script{
                    echo "Test4: Output to console with variable returned from object."
                    echo "Build ID - ${Obj_Helper.BuildId}"
                    echo "Build Name - ${Obj_Helper.BuildName}"
                }
            }
        }
    }
}