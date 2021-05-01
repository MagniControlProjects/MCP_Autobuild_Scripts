/*
 *   @author: George Linsdell
 *   @date:01/05/2021
 *   Contains a helper object as an initial test to see how objects work. 
 *   Object will grow to support minimal requirements in jobs.
 *   The assumption is made that jenkins Environment variables are present.
 *   
 *   Notes:
 *   evaluate is a key term for importing script. load abstracts a layer up from this.
 * 
 * 
 */

Object GetProperty (String name){
    return this.getClass().GetClassLoader().loadClass(name).newInstance();
}

class HelperObject {
    
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
    
    def  initialize (){
        this.Workspace = "${WORKSPACE}"
        echo "Workspace is ${this.Workspace}"
        this.BuildId = "${BUILD_ID}"
        this.BuildName = "${BUILD_NAME}"
        
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
