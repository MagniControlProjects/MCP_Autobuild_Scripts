pipeline{
    agent {
        label "${AGENT_LABEL}"
    }
    stages{
        stage ("STAGE: Initialize Job"){
            steps{
                script{
                    
                    COMMON_UTILS_LOAD_LOCATION = "${WORKSPACE}/autobuild/CommonUtils/main.groovy"
                    echo ("CommonUtils at ${COMMON_UTILS_LOAD_LOCATION}")
                    HelperScript = load (COMMON_UTILS_LOAD_LOCATION)
                    Obj_Helper = HelperScript.GetHelperObject()
                    
                }
            }
        }
        stage("STAGE: Checkout Dependencies"){
            steps{
                script{
                    echo "Do Stuff"
                    Obj_Helper.initialize("${WORKSPACE}","${BUILD_ID}","${JOB_NAME}")
                    test = [1,2,3]
                    echo test
                    test.each{echo ${it}}}
                }
            }
        }
        stage("STAGE: Setup Build Folder"){
            steps{
                script{
                    echo "Do Stuff"
                    Obj_Helper.test()
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