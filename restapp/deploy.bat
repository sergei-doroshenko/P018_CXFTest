del "D:\Tomcat\apache-tomcat-8.0.33\webapps\restapp.war"
del /s /q "D:\Tomcat\apache-tomcat-8.0.33\webapps\restapp\"

::mvn clean package

xcopy D:\Projects\P018_CXFTest\restapp\target\restapp.war D:\Tomcat\apache-tomcat-8.0.33\webapps\
::copy \target\restapp.war "D:\Tomcat\apache-tomcat-8.0.33\webapps\"

D:\Tomcat\apache-tomcat-8.0.33\bin\startup.bat