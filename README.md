EF-jobapplication-webapp
========================
Author: Šimun Cecelja
Technologies: CDI, JPA, EJB, JPA, JAX-RS, BV
Target Project: WildFly




Build and Deploy
-------------------------

1. Open a command line and navigate to the root directory of this quickstart.
2. Type this command to build and deploy the archive:

        mvn clean package wildfly:deploy

4. This will deploy `target/EF-jobapplication-webapp.war` to the running instance of the server.
 

Access the application 
---------------------

The application will be running at the following URL: <http://localhost:8080/EF-jobapplication-webapp/>.



