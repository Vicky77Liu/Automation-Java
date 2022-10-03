$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/quotePred.feature");
formatter.feature({
  "name": "Quote Predefined",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@quotePred"
    }
  ]
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@quotePred"
    },
    {
      "name": "@quotePred1"
    }
  ]
});
});