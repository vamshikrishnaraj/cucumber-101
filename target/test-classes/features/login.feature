Feature: URBAN LADDER

Scenario: verifying search operation
Given driver is initialized
And the url "https://www.urbanladder.com/" is entered
When searched for "Tv Stand"
Then search page is loaded and the "'Tv Stand'" result is verfied
And quit

Scenario: verifying list size
Given driver is initialized
When the url "https://www.urbanladder.com/" is entered
Then list options are counted and verified to 10
And quit

Scenario: verifying the hovering feature
Given driver is initialized
When the url "https://www.urbanladder.com/" is entered
Then hovered to lists and the "Sofa Set" option is visible
And quit

Scenario: verifying the title
Given driver is initialized
When the url "https://www.urbanladder.com/" is entered
Then verify the title "Urban Ladder"
And quit

Scenario: verifying a particular option is present in the categories list
Given driver is initialized
When the url "https://www.urbanladder.com/" is entered
Then verify whether the "study table" is present in categories list
And quit

Scenario: email invalidity
Given driver is initialized
When the url "https://www.urbanladder.com/" is entered
Then "xyz" is given as the input mail id
And later the invalid messsage "Please enter a valid email address." is prompted
And quit

Scenario: logging in
Given driver is initialized
When the url "https://www.urbanladder.com/" is entered
And signup page is opened
Then "samsettyvamshi35@gmail.com" as mail and "qwertyuiop" as password it should signup
And quit

Scenario: subscribe the website
Given driver is initialized
When the url "https://www.urbanladder.com/" is entered
Then got to subscription step and enter the "xyz@gmail.com" as mail id and subscribe
And quit

Scenario: social media count
Given driver is initialized
When the url "https://www.urbanladder.com/" is entered
Then go to socoial media section and verify if all the socoal media websites are present
And quit

Scenario: address verification
Given driver is initialized
When the url "https://www.urbanladder.com/" is entered
Then verify this "Reliance Retail Ltd" is contained in the address
And quit














