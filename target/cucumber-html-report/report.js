$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MMTSearchHotel.feature");
formatter.feature({
  "line": 1,
  "name": "Testing MakeMyTrip Hotel Search",
  "description": "",
  "id": "testing-makemytrip-hotel-search",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4380491200,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "",
  "description": "",
  "id": "testing-makemytrip-hotel-search;",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Runme"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I navigate to makemytrip website",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I login using username \"vedantu.assignment.2021@gmail.com\" and password \"Vedantu@2021\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I navigate to hotels tab",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I search Hotel in \"Bangalore\" for \"2\" Adults and \"1\" child of \"2\" years",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I apply price filter of minimum \"1000\" to maximum \"20000\" and select first hotel",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I remove the price filter and select first hotel",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I logout from makemytrip",
  "keyword": "And "
});
formatter.match({
  "location": "MMTStepDefinitions.navigate_to_makemytrip_website()"
});
formatter.result({
  "duration": 9530579799,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "vedantu.assignment.2021@gmail.com",
      "offset": 24
    },
    {
      "val": "Vedantu@2021",
      "offset": 73
    }
  ],
  "location": "MMTStepDefinitions.loginUsingSingleSignOn(String,String)"
});
formatter.result({
  "duration": 31112749999,
  "status": "passed"
});
formatter.match({
  "location": "MMTStepDefinitions.navigate_to_hotels_tab()"
});
formatter.result({
  "duration": 1374733200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bangalore",
      "offset": 19
    },
    {
      "val": "2",
      "offset": 35
    },
    {
      "val": "1",
      "offset": 50
    },
    {
      "val": "2",
      "offset": 63
    }
  ],
  "location": "MMTStepDefinitions.searchHotel(String,String,String,String)"
});
formatter.result({
  "duration": 17973420600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000",
      "offset": 33
    },
    {
      "val": "20000",
      "offset": 51
    }
  ],
  "location": "MMTStepDefinitions.apply_price_filter_and_select_hotel(String,String)"
});
formatter.result({
  "duration": 21651996099,
  "status": "passed"
});
formatter.match({
  "location": "MMTStepDefinitions.remove_price_filter_and_select_hotel()"
});
formatter.result({
  "duration": 5350521101,
  "status": "passed"
});
formatter.match({
  "location": "MMTStepDefinitions.logout_from_makemytrip()"
});
formatter.result({
  "duration": 2629097700,
  "status": "passed"
});
});