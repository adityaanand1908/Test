@SendLatestHighlights
Feature: Test the send message features to recipients

	@SendLatestHighlightsAT001
  Scenario: Validation of sending the latest highlights to coaches 
    Given User Navigates to Highlights tab and selects the latest sport highlights to share 
    Then User send the new message to the list of recipients to validate that message is been sent successfully to listed recipients and get the count of recipients viewed and not viewed the sent message