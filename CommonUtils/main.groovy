/*
 *   @author: George Linsdell
 *   @date:01/05/2021
 *   Contains a helper object as an initial test to see how objects work. 
 *   Object will grow to support minimal requirements in jobs.
 *   The assumption is made that jenkins Environment variables are present.
 *   
 *   Notes:
 *   evaluate is a key term for importing script. load abstracts a layer up from this.
 *   Objects cannot pull or set from environment. therefore all must be handed over manually.
 * 
 */



class HelperObject {
    
    def Workspace = String
    def BuildID = String 
    def BuildName = String
    def  initialize (
            String WORKSPACE,
            String BUILDID,
            String BUILDNAME
            ){
        Workspace = WORKSPACE;
        BuildId = BUILDID;
        BuildName = BUILDNAME;
        echo "CleanEcho."
        echo "Workspace is ${this.Workspace}"
        echo "Helper Initialized for Build Name ${this.BuildName}-${this.BuildId}"
    }
    
    def  test (){
        echo "test method Entered"
        echo "${WORKSPACE}
    }
    
    def testReturn (){
        echo "InTestReturn"
        return "${this.WORKSPACE}"
    }
}

def GetHelperObject(){
    return new HelperObject()
}

return this;