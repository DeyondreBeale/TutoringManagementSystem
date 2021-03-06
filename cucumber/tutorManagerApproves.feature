#These are Planned Goals

Feature: Tutor Manager Approves Tutors

Background: 
    Given User is signed in as tutor manager

Scenario: Tutor manager approves tutor's account
	And Viewing tutors Tab
	When Clicks to approve new tutor account 
	Then New tutor account should be activated

Scenario: Tutor manager approves tutor schedule
	And Viewing the tutors' schedules
	When Clicks on approve schedule
	Then Tutor's schedule is approved