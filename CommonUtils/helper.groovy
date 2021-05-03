/*
 *   @author: George Linsdell
 *   @date:03/05/2021
 *   Contains a helper object as an initial test to see how objects work. 
 *   Object will grow to support minimal requirements in jobs.
 *   The assumption is made that jenkins Environment variables are present.
 *   
 *  apparently << = append to list.
 * 
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