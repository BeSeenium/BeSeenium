# BeSeenium
The main idea behind BeSeenium is to provide an easy to use browser automation system for non 
programmers. It provides a RESTful(ish) API that users can hook into via any web server; a basic 
UI (very basic) is also provided.

##Requirements
- Java runtime environment (java 1.8).
- a network connection to wherever BeSeenium is running.
- If local testing is required for graphical browsers, BeSeenium must be running on a machine with a Desktop 
manager.

##Installation
no formal installation needs to be carried out, however if by chance you have come accross this readme without
the accompanying src please follow the instructions below.
###GIT
clone this repository from <https://github.com/jpchanson/BeSeenium.git>, compile the source code, create a runnable jar
 and follow the instructions below.

###Non-GIT
Visit <https://github.com/jpchanson/BeSeenium>, on the right hand side of the page is a "download ZIP", unzip the file
and follow the same steps as above.

##Starting the application
Start the application from the command line using: **`"java -jar BeSeenium.jar [port number]"`**, replacing
[port number] with the port you wish BeSeenium to run on. 

##API
BeSeenium uses the Jetty embedded servlet container to provide a RESTful(ish) API that can be accessed
to run tests. In brief, to run a test submit a http request to **`[your IP]/results`** using the form:

**`[yourIP]:[portNo]/results?browser=[browserChoice]&capabilities=[capabilitiesList]&addActions=[actionList]`**

replacing anything in square brackets with appropriate values.

for more details and other documentation see <https://github.com/jpchanson/BeSeenium/wiki>