pipeline{
    agent {
        label "${AGENT_LABEL}"
    }
    stage ("Initialize Job"){
        steps{
            script{
                echo ("Load autobuild main containing helper object")
                load ("${WORKSPACE}/autobuild/main.groovy")
                Helper = new Helper()
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
    stage("Setup Build Folder"){}
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