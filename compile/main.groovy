pipeline{
    agent {
        label "${AGENT_LABEL}"
    }
    stage ("Initialize Job"){
        steps{
            script{
                import main.HelperObject
                COMMON_UTILS_LOAD_LOCATION = "${WORKSPACE}/autobuild/CommonUtils/main.groovy"
                load (COMMON_UTILS_LOAD_LOCATION)
                echo ("CommonUtils at ${COMMON_UTILS_LOAD_LOCATION}")
                def JobHelper = new HelperObject().with{
                    loadScriptByName (COMMON_UTILS_LOAD_LOCATION)
                    
                }
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