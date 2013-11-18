/**
 * Created with IntelliJ IDEA.
 * User: mukesh.kumar
 * Date: 8/26/13
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 * script to update svn repositories
 */
//add repositories to this list as needed
def repositories = ['C:\\Projects\\branches\\2013_projects\\some_svn_repository_1',        
        'C:\\Projects\\branches\\2013_projects\\some_svn_repository_2',
        'C:\\Projects\\branches\\2013_projects\\some_svn_repository_3']
def day = new Date()
println "\n************Starting updating svn repositories: Date: $day ****"
repositories.each {
    def svn_command = "svn_update.bat $it"// Create the String
    proc = svn_command.execute()                 // Call *execute* on the string
    proc.waitFor()                               // Wait for the command to finish
// Obtain status and output
    println "return code for: $svn_command: ${ proc.exitValue()}"
    println "stderr for: $svn_command:  ${proc.err.text}"
    println "stdout for: $svn_command: ${proc.in.text}" // *out* from the external program is *in* for groovy
    println "\n"
}
println "***************Done updating svn repositories*******************"