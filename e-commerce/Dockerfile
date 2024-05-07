# Use OpenJDK 11 as base image
FROM openjdk:11



# Expose the port your application runs on (default is 8080)
EXPOSE 8080

ADD target/e-commerce.jar e-commerce.jar

# Command to run the application when the container starts
CMD ["java", "-jar", "/e-commerce.jar"]
