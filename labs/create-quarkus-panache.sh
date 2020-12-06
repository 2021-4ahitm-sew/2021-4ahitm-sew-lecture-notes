mvn io.quarkus:quarkus-maven-plugin:1.9.2.Final:create \
    -DprojectGroupId=at.htl \
    -DprojectArtifactId=quarkus-panache-demo \
    -DclassName="at.htl.panache.boundary.GreetingResource" \
    -Dpath="/hello"
