# CS320-JUnit-Project: Service Management and JUnit Testing Project
## OVERVIEW
This repository provides code created to create a management system for handling Contact, Task, and Appointment entities using respective service classes.
The project focuses on building a fully unit-tested codebase using JUnit 5 to build and emphasize best software testing and QA practices and ensure adherence to specified requirements.
- Coded by Michael Lorenz for SNHU CS320, Software testing, Automation QA Course.

Each Service class manages its respective entity objects with functionality for adding, deleting, and updating objects. Using JUnit 5, requirements are tested such as the following requirements:
- each entity object should have a non-null, non-updatable ID field unique within its class
- each field has specific character-length requirements and should be required, non-null, and updatable

## REFLECTION
### How can I ensure that my code, program, or software is functional and secure?
A key aspect of ensuring the program is functional is fully understanding the client's needs and ensuring each of the client's requirements is met. 
This aids the program by making sure it behaves as expected by the client. Additionally, a key aspect of ensuring the code is functional and secure is thorough testing.
I implemented extensive unit testing using various white-box and black-box testing techniques to identify and design tests that check for correctness and safety,
such as proper input validation.

### How do I interpret user needs and incorporate them into a program?
To interpret user needs I began by thoroughly analyzing the requirements provided for each class. Using a detailed list of requirements, 
I identified needs such as a requirement for validating the character length for Contact fields like firstName, lastName, phone, and address. 
I recognized other user needs like the ability for ContactService to add, delete, and update Contact objects. I ensure the features meet user needs as expected by 
creating unit tests to verify each requirement is met, such as checking that fields are non-null and Contact objects have unique IDs throughout execution. 

### How do I approach designing software?
When designing software from scratch, such as this project, I start by identifying the essential requirements, such as the user needs mentioned above, and outlining manageable
components for those requirements. For example, I created individual methods for required operations like adding Contact objects to ContactService, removing them, updating
each field, and verifying data. Using a test-driven development approach, I guided the design process by ensuring that most tests derived from the user's needs were written
before implementing the functionality corresponding to those tests. This allows me to structure the software and testing program to validate correctness and ensure the
implementation adheres strictly to requirements while catching any defects early to be promptly resolved.
