/* Copyright 2021 George Linsdell
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this 
 * software and associated documentation files (the "Software"), to deal in the Software 
 * without restriction, including without limitation the rights to use, copy, modify, 
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall be included in all copies 
 * or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE 
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */

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