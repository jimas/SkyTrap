@echo off
set groupId=com.jimas.weixin.skytrap
set artifactId=SkyTrap-api
set version=0.0.3
set SNAPSHOT=true
set packaging=jar
set jarFullName=%artifactId%-%version%-SNAPSHOT
set url=http://maven.hubs1.net/nexus/content/repositories/Snapshots
set repository=snapshots

set dversion=%version%-SNAPSHOT
if "%SNAPSHOT%" == "true" goto gotMvn
    set dversion=%version%
    set jarFullName=%artifactId%-%version%
    set repository=releases
    set url=http://maven.hubs1.net/nexus/content/repositories/releases
:gotMvn
mvn  deploy:deploy-file -DgroupId=%groupId% -DartifactId=%artifactId%  -Dversion=%dversion% -Dpackaging=%packaging%  -Dfile=target\%jarFullName%.jar -DrepositoryId=%repository% -Durl=%url%

pause