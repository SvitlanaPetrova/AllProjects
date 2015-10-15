Check arithmetical operations
Narrative:
In order to verify that google calculator work correctly
As a user of google
I should be able to get correct results operations

Scenario: Check operations
Given the user is on the google calculator page
When the user click on the buttons one by one for receive field 'action'
Then the user should see a correct result of action 'expectedResult'

Examples:
|action|expectedResult|
|134*12=|1608|
|-0.5*-3=|1.5|
|145/5=|29|
|145.5/5=|29.1|
|-300+300=|0|
|0-0.001=|-0.001|
|12/0=|Infinity|
|14.6-(5+9.9)/0=|Infinity|
|.+=|Error|

