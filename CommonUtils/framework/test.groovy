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
                }
            }
        }
        stage("STAGE: Print To console from inside Object Not Possible, use iterator method and getter"){
            steps{
                script{
                    echo "Test1: Output event performed by object by retreiving the trace."
                    echo "From imported method, the actions of helper object were:"
                    Obj_Helper.testObjectToConsole()
                    HelperScript.printTrace(Obj_Helper.getTrace(true))
                    echo "Test1: Complete."
                }
            }
        }
        stage("STAGE: Print to console from variable returned from object"){
            steps{
                script{
                    echo "Test2: Output to console with variable returned from object."
                    returnVal = Obj_Helper.testReturn()
                    echo "From Pipeline Script, Workspace is ${returnVal}"
                    echo "Test2: Complete."
                }
            }
        }
        stage("STAGE: Print Properties of the object"){
            steps{
                script{
                    echo "Test3: Output to console with variables returned from object."
                    echo "Build ID   : ${Obj_Helper.BuildId}"
                    echo "Build Name : ${Obj_Helper.BuildName}"
                    echo "Workspace  : ${Obj_Helper.Workspace}" 
                    echo "Test3: Complete."
                }
            }
        }
    }
}