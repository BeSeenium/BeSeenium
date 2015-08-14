# BeSeenium
The main idea behind BeSeenium is to provide an easy to use browser automation system for non 
programmers. It provides a RESTful(ish) API that users can hook into via any web server; a basic 
UI (very basic) is also provided.

##Requirements
- Java runtime environment.
- a network connection to wherever BeSeenium is running.

##Starting the application
Start the application from the command line using: "java -jar BeSeenium [port number]", replacing
[port number] with the port you wish BeSeenium to run on. 

##API
BeSeenium uses the Jetty embedded servlet container to provide a RESTful(ish) API that can be accessed
to run tests (for more details see the wiki at https://github.com/jpchanson/BeSeenium/wiki).

in brief, to run a test submit a http request to "[your IP]/results" using the form:

'''[yourIP]:[portNo]/results?browser=[browserChoice]&capabilities=[capabilitiesList]&addActions=[actionList]'''

replacing anything in square brackets with appropriate values.