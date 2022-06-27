System.out.println("Executing .gitignore hack")
file = new File( request.getOutputDirectory(), request.getArtifactId()+"/.gitignore.tmpl" );
def gitIgnorefile = new File( request.getOutputDirectory(), request.getArtifactId()+"/.gitignore" );
file.renameTo(gitIgnorefile)

def activeProfiles = request.getProjectBuildingRequest().getActiveProfileIds()
def isWindows = false
def isUnix = false
for (i=0;i<activeProfiles.size();i++) {
    if(activeProfiles[i].equals("windows-local-build"))
        isWindows=true
    if(activeProfiles[i].equals("unix-local-build"))
        isUnix=true
}
def mavenPackageProcess
if(isWindows && isUnix) {
    System.out.println("BOTH windows and UNIX profiles? Check your config...")
    System.exit(1)
}
else if(isWindows) {
    System.out.println("Executing 'mvn package -DskipTests=true' in directory "+request.getArtifactId())
    mavenPackageProcess = new ProcessBuilder("mvn.cmd","package","-DskipTests=true").directory(new File(request.getArtifactId())).start()
}
else if(isUnix) {
    System.out.println("Executing 'mvn package -DskipTests=true' in directory "+request.getArtifactId())
    mavenPackageProcess = new ProcessBuilder("mvn","package","-DskipTests=true").directory(new File(request.getArtifactId())).start()
}
else {
    System.out.println("NEITHER windows NOR UNIX profiles? Check your config...")
    System.exit(1)
}
mavenPackageProcess.waitForProcessOutput(System.out, System.err)

System.out.println("Executing 'mvn clean' in directory "+request.getArtifactId())
def mavenCleanProcess
if(isWindows && isUnix) {
    System.out.println("BOTH windows and UNIX profiles? Check your config...")
    System.exit(1)
}
else if(isWindows) {
    System.out.println("Executing 'mvn package -DskipTests=true' in directory "+request.getArtifactId())
    mavenCleanProcess = new ProcessBuilder("mvn.cmd","clean").directory(new File(request.getArtifactId())).start()
}
else if(isUnix) {
    System.out.println("Executing 'mvn package -DskipTests=true' in directory "+request.getArtifactId())
    mavenCleanProcess = new ProcessBuilder("mvn","clean").directory(new File(request.getArtifactId())).start()
}
else {
    System.out.println("NEITHER windows NOR UNIX profiles? Check your config...")
    System.exit(1)
}
mavenCleanProcess.waitForProcessOutput(System.out, System.err)

System.out.println("Initializing git")
def initProcess = new ProcessBuilder("git","init").directory(new File(request.getArtifactId())).start()
initProcess.waitForProcessOutput(System.out, System.err)
def addProcess = new ProcessBuilder("git","add",".").directory(new File(request.getArtifactId())).start()
addProcess.waitForProcessOutput(System.out, System.err)
def commitProcess = new ProcessBuilder("git","commit","-m","chore: initial commit").directory(new File(request.getArtifactId())).start()
commitProcess.waitForProcessOutput(System.out, System.err)

System.out.println("Done!")