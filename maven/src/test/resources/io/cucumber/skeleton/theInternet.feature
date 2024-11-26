Feature: The Internet
  This feature covers (some) Example pages on 'the-internet.herokuapp.com'

  @TEST_TI_0001
#  Scenario Outline: Homepage has a list of links to Expected examples
#    Given the page under test is 'https://the-internet.herokuapp.com'
#    And an example Home Page step
#    Then the list contains a list item with title "<title>"
#
#    Examples:
#      | title                                        |
#      | Add/Remove Elements                          |
#      | Basic Auth (user and pass: admin)            |
#      | Broken Images                                |
#      | Challenging DOM                              |
#      | Context Menu                                 |
#      | Digest Authentication (user and pass: admin) |
#      | Disappearing Elements                        |
#      | Drag and Drop                                |
#      | Dropdown                                     |
#      | Dynamic Content                              |
#      | Dynamic Controls                             |
#      | Dynamic Loading                              |
#      | Entry Ad                                     |
#      | Exit Intent                                  |
#      | File Download                                |
#      | File Upload                                  |
#      | Floating Menu                                |
#      | Forgot Password                              |
#      | Form Authentication                          |
#      | Geolocation                                  |
#      | Horizontal Slider                            |
#      | Infinite Scroll                              |
#      | Inputs                                       |
#      | JavaScript Alerts                            |
#      | JavaScript onload event error                |
#      | Key Presses                                  |
#      | Large & Deep DOM                             |
#      | Multiple Windows                             |
#      | Nested Frames                                |
#      | Notification Messages                        |
#      | Redirect Link                                |
#      | Secure File Download                         |
#      | Shadow DOM                                   |
#      | Shifting Content                             |
#      | Slow Resources                               |
#      | Sortable Data Tables                         |
#      | Status Codes                                 |
#      | Typos                                        |
#      | WYSIWYG Editor                               |


#    And you can navigate to that page

  @TEST_TI_0001
  Scenario: Basic Auth allows validated access
    Given the page under test is 'https://the-internet.herokuapp.com'
    When the 'Basic Auth' example is opened
    And valid credentials are supplied
    Then Congratulations should be displayed
#
#  @TEST_TI_0001
#  Scenario: Sortable Data Tables - Example 1 displays the expected 4 results
#    Given the page under test is 'Sortable Data Tables'
#    And add other steps