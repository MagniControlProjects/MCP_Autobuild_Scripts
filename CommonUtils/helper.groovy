/*
 *   @author: George Linsdell
 *   @date:03/05/2021
 *   Contains a helper object as an initial test to see how objects work. 
 *   Object will grow to support minimal requirements in jobs.
 *   The assumption is made that jenkins Environment variables are present.
 *   
 * 
 */

def PrintToLog(String StringToPrint){
    println("${StringToPrint}\n")
    return
}

//Definition of a class object named "HelperObject"
class HelperObject {
    //Definition of Class attributes.
    def Workspace = String 
    def BuildId = String 
    def BuildName = String
    // Constructor method, class requires passing of parameters on creation.
    HelperObject (
            String WORKSPACE,
            String BUILDID,
            String BUILDNAME
            ){
        Workspace = WORKSPACE;
        BuildId = BUILDID;
        BuildName = BUILDNAME;
        PrintToLog("Workspace is ${this.Workspace}")
        PrintToLog("Helper Initialized for Build Name ${this.BuildName}-${this.BuildId}")
    }
    
    def testObjectToConsole (){
        // Print something to the console from inside the object class.
        print ("Inside HelperObject, testObjectToConsole method.")
        print ("${Workspace}")
        return
    }
    
    def testReturn (){
        // Returnt the value of an attribute which may be generated inside the method.
        print ("InTestReturn")
        return "${Workspace}"
    }
    
    def print(String StringToPrint){
        PrintToLog(StringToPrint);
        return
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