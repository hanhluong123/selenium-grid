cd C:\Users
java -jar selenium-server-standalone-2.53.1.jar -role webdriver -hub http://192.168.189.93:4444/grid/register -port 8882 -browser browserName=ie,maxInstances=5,maxSession=2