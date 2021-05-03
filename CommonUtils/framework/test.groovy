/*
 *   @author: George Linsdell
 *   @date:03/05/2021
 *   Contains a helper object as an initial test to see how objects work. 
 *   Object will grow to support minimal requirements in jobs.
 *   The assumption is made that jenkins Environment variables are present.
 *   
 * 
 */

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
        println "Workspace is ${this.Workspace}"
        println "Helper Initialized for Build Name ${this.BuildName}-${this.BuildId}"
    }
    
    def  testObjectToConsole (){
        // Print something to the console from inside the object class.
        println "Inside HelperObject, testObjectToConsole method."
        println "${Workspace}"
    }
    
    def testReturn (){
        // Returnt the value of an attribute which may be generated inside the method.
        println "InTestReturn"
        return "${Workspace}"
    }
}

//Accessor method to get the helper object.
def GetHelperObject(){
    return new HelperObject()
}

return this;