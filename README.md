# PageFreezer

## Description

This repository hosts the automation suite for the PageFreezer public portal. It leverages a Behavior-Driven Development (BDD) approach, utilizing Java, Selenium, and Cucumber in conjunction with the Page Object Model pattern to conduct tests and ensure the portal's functionality is validated effectively

## Prerequisites

- Java JDK 11 or higher: The project requires a minimum of Java 11 to run. You can download the appropriate version of Java JDK from the [Official Oracle Website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [AdoptOpenJDK](https://adoptopenjdk.net/).
- Maven: Ensure that Maven is installed on your system. You can download it from the [Official Apache Maven Website](https://maven.apache.org/download.cgi).

## Getting Started

Follow these steps to get the project up and running on your local machine for development and testing purposes.

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/Elakkiaduraisamy/pagefreezer.git

2. Navigate to the project root directory :
   ```sh
   cd pagefreezer/publicportal

3. Run the Test:
   ```sh
   mvn clean test

4. Test report can be found under:
   ```sh
   cd pagefreezer/publicportal/target/pagefreezer-reports.html
   
5. The report should display a result indicating that out of 4 test cases, 3 have passed successfully, while one has failed.   
