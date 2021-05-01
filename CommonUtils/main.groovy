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

class HelperObject (){
    
    static void main (){
        //Overloading the main method to allow non arguments to be passed for initial testing.
        this.args = {}
        this.initialize()
    }
    
    static void main (String [] args){
        //In theory, args may be used to overwrite
        this.args = args
        
        this.initialize()
    }
    
    static void initialize (){
        this.Workspace = "${WORKSPACE}"
        echo `Workspace is ${this.Workspace}`
        this.BuildId = "${BUILD_ID}"
        this.BuildName = "${BUILD_NAME}"
        
        echo `Helper Initialized for Build Name ${this.BuildName}-${this.BuildId}`
    }
    
    static void test (){
        echo "test method Entered"
    }
}