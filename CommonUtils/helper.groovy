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
 * 
 * @date:03/05/2021
 * Contains a helper object as an initial test to see how objects work. 
 * Object will grow to support minimal requirements in jobs.
 * The assumption is made that jenkins Environment variables are present..
 */

def printTrace (List tracelist){
    tracelist.each{
        println("${it}")
    }
    return
}

//Definition of a class object named "HelperObject"
class HelperObject {
    //Definition of Class attributes.
    def Workspace = String 
    def BuildId = String 
    def BuildName = String
    def _DestroyTrace = false
    def trace = []
    // Constructor method, class requires passing of parameters on creation.
    HelperObject (
            String WORKSPACE,
            String BUILDID,
            String BUILDNAME
            ){
        Workspace = WORKSPACE;
        BuildId = BUILDID;
        BuildName = BUILDNAME;
    }
    
    def GetWorkspace(){
        println("Get Workspace ${this.Workspace}")
        appendTrace("Workspace is ${this.Workspace}")
        appendTrace("Helper Initialized for Build Name ${this.BuildName}-${this.BuildId}")
        return
    }
    
    def appendTrace(Item){
        if (_DestroyTrace){
            trace = []
            _DestroyTrace = false
        }
        trace << "[Trace] ${Item}"
        return
    }
    
    def getTrace (Boolean DestroyTrace){
            // As I can't seem to print from terminal, action will be stored in a trace.
            _DestroyTrace = DestroyTrace // Flag for destruction of trace on next append
        return  trace
    }
    
    def getTrace (){
        return trace
    }
    
    def testObjectToConsole (){
        // Print something to the console from inside the object class.
        appendTrace("Inside HelperObject, testObjectToConsole method.")
        appendTrace("${Workspace}")
        return
    }
    
    def testReturn (){
        // Returnt the value of an attribute which may be generated inside the method.
        appendTrace("InTestReturn")
        return "${Workspace}"
    }
    
}

def GetHelperObject(
        String WORKSPACE,
        String BUILDID,
        String BUILDNAME
        ){
    // Accessor method to get the helper object.
    println("Generating Helper Object")
    return new HelperObject(
            WORKSPACE,
            BUILDID,
            BUILDNAME
            )
}

return this;