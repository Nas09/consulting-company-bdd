# language: fr
@adresse @modification
Fonctionnalité: Create a new Employee

  @TestsRecevabilité
  @scenarioTest
  Plan du scénario: New Employee creation
    Etant donné new Employee with a FirstName <firstName> , Lastname <lastName>, Adress <adress>
    Lorsque a user create the new Employee
    Alors the new Employee is created
    Exemples:
      | firstName | lastName   | adress         |
      | Youssef   | Smimma     | 14 rue V       |