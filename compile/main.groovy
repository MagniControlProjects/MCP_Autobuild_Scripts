pipeline{
    agent {
        label "${AGENT_LABEL}"
    }
    stage ("Initialize Job"){
        steps{
            script{
                echo ("Load autobuild main containing helper object")
                tools = load ("${WORKSPACE}/autobuild/CommonUtils/main.groovy")
                def JobHelper = new HelperObject()
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