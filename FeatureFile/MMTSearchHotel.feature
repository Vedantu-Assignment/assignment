Feature: Testing MakeMyTrip Hotel Search

@Runme

Scenario: 

Given I navigate to makemytrip website
And I login using username "vedantu.assignment.2021@gmail.com" and password "Vedantu@2021"
Then I navigate to hotels tab
And I search Hotel in "Bangalore" for "2" Adults and "1" child of "2" years. I book after "7" days from now
Then I apply price filter of minimum "1000" to maximum "20000" and select first hotel
Then I remove the price filter and select first hotel
And I logout from makemytrip
