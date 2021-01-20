warning: LF will be replaced by CRLF in reservas-backend/microservicio/infraestructura/src/test/java/com/ceiba/ApplicationMock.java.
The file will have its original line endings in your working directory
[1mdiff --git a/reservas-backend/microservicio/infraestructura/src/test/java/com/ceiba/ApplicationMock.java b/reservas-backend/microservicio/infraestructura/src/test/java/com/ceiba/ApplicationMock.java[m
[1mindex 8fe8aea..f675254 100644[m
[1m--- a/reservas-backend/microservicio/infraestructura/src/test/java/com/ceiba/ApplicationMock.java[m
[1m+++ b/reservas-backend/microservicio/infraestructura/src/test/java/com/ceiba/ApplicationMock.java[m
[36m@@ -24,10 +24,10 @@[m [mpublic class ApplicationMock {[m
 [m
     @Bean(initMethod = "migrate")[m
     Flyway flyway(DataSource dataSource) throws IOException {[m
[31m-[m
[31m-        return Flyway.configure().locations("filesystem:../src/main/resources","filesystem:src/test/resources").baselineOnMigrate(true)[m
[32m+[m[41m    [m	[32mFlyway flyway = Flyway.configure().locations("filesystem:../src/main/resources","filesystem:src/test/resources").baselineOnMigrate(true)[m
                 .dataSource(dataSource).load();[m
[31m-[m
[32m+[m[41m    [m	[32mflyway.migrate();[m
[32m+[m[32m        return flyway;[m
     }[m
 [m
     @Bean[m
