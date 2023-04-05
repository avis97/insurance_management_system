# insurance_management_system
This Is a incurace management System app.Have three entities like Client,Policies and claims.
a Client can have more than one policies plan with more than one claims.
User can Check the all policies and client details by this project and admin can manage the all details by some Rest api.

### MAVEN SPRING DEPENDENCY
* MySql Driver.
* Soring JPA(hibernate)
* Lombook
* Spring web

### MODELS
* Client
* Policies
* Claim
### PACKAGE
* Models
* Controller
* Repositorys
* Services
* DTOs
* Exception
* Enum
* Converter

## Maping
CLIENT TO POLICIES --> ONE TO MANY.  
POLICIES TO CLAIM -->  ONE TO MANY.

CLIENT AS A PARENT HERE FOR HANDEL THE DATABASES.



## Screenshot  

*SOME APIS IN SWAGGER MODELS->

![Screenshot (140)](https://user-images.githubusercontent.com/106426358/229227181-ea085f92-97e0-4122-a7ad-7fe3e0c2e1c8.png)

*ER MODELS

![Screenshot (141)](https://user-images.githubusercontent.com/106426358/229227020-27621aeb-8c3b-472d-aab4-e0b4c7bf1324.png)
