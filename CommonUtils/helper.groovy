/*
 *   @author: George Linsdell
 *   @date:03/05/2021
 *   Contains a helper object as an initial test to see how objects work. 
 *   Object will grow to support minimal requirements in jobs.
 *   The assumption is made that jenkins Environment variables are present.
 *   
 * 
 */

printObjectTrace(Object TraceableObject){
    printObjectTrace(
        TraceableObject,
        true
    )
}

printObjectTrace (
        Object TraceableObject,
        Boolean CleanAfterPrint //Defaults too true if called only with 1 parameter
        ){
    for (i in TraceableObject.trace){
        println(i)
    }
    if (CleanAfterPrint){
        try{
            TraceableObject.clearTrace
        }
        except{
            println("Unable to clear trace with method, trying manual overwrite")
            TraceableObject.trace = []
        }
    }
    
}

printTrace (list tracelist){
    for (i in tracelist){
        println("${i}n")
    }
    return
}

//Definition of a class object named "HelperObject"
class HelperObject {
    //Definition of Class attributes.
    def Workspace = String 
    def BuildId = String 
    def BuildName = String
    trace = List
    // Constructor method, class requires passing of parameters on creation.
    HelperObject (
            String WORKSPACE,
            String BUILDID,
            String BUILDNAME
            ){
        Workspace = WORKSPACE;
        BuildId = BUILDID;
        BuildName = BUILDNAME;
        trace.append("Workspace is ${this.Workspace}")
        trace.append("Helper Initialized for Build Name ${this.BuildName}-${this.BuildId}")
    }
    
    def clearTrace (){
        // As I can't seem to print from terminal, action will be stored in a trace.
        trace = trace
        return  
    }
    
    def testObjectToConsole (){
        // Print something to the console from inside the object class.
        trace.append ("Inside HelperObject, testObjectToConsole method.")
        trace.append ("${Workspace}")
        return
    }
    
    def testReturn (){
        // Returnt the value of an attribute which may be generated inside the method.
        trace.append ("InTestReturn")
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