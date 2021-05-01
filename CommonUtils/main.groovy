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
    
    def args = {}
    
    def  main (){
        //Overloading the main method to allow non arguments to be passed for initial testing.
        this.args = {}
        this.initialize()
    }
    
    def  main (String [] args){
        //In theory, args may be used to overwrite
        this.args = args
        
        this.initialize()
    }
    
    def  initialize (WORKSPACE,BUILDID,BUILDNAME){
        this.Workspace = WORKSPACE
        this.BuildId = BUILDID
        this.BuildName = BUILDNAME
        echo "Workspace is ${this.Workspace}"
        echo "Helper Initialized for Build Name ${this.BuildName}-${this.BuildId}"
    }
    
    def  test (){
        echo "test method Entered"
    }
    
    def testReturn (){
        return "ReturnedStuff"
    }
}

def GetHelperObject(){
    return new HelperObject()
}

return this;