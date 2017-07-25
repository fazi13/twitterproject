# twitterproject
What does not work:
* Tree on admin panel does not have hierarchy, just shows all groups and users in root 
* Sub groups do not become a leaf of a group visually
* There is no way to make a user a part of a group without the console

Using the admin panel
1. Add User
    1. If no user id is inputted, id will be +1 from last user id
    2. otherwise will attempt to use inputted id
        1. if user id already in use error will appear
2. Add Group
    1. group id will automatically be next available id
    2. if no parent id is set, it will be root
        1. if parent id does not exist, error will occur
3. Select User
    1. able to select user from tree on left
        1. if a group is selected, show user will not work
    2. show user will display a new screen with the selected user's info
        1. data is updated live but data from other users will not be reflected until refreshed
4. Show Total Buttons
    1. all buttons work
    
Using the show user panel
1. Current User
    1. shows username and user id
2. Follow User
    1. starts following that user and updates list
        1. tweets that the user posted before current user started following will not display in the newsfeed, only new tweets after current user started following will show
        2. if that user does not exist, error will occur
3. Post Tweet
    1. posts that tweet to newsfeed
    2. posts it to users that are following newsfeed
        1. will not be updated on other newsfeeds live, window must be refreshed
4. News Feed
    1. shows all of the user's tweets
    2. shows all of the user's following's tweets
        1. only shows tweets after the user started to follow them. eg: started following at 11:01 messages before 11:01 are not shown
    3. refreshed when user adds a new tweet
        1. to show tweets from following's must refresh window


Observer pattern was not implemented with Java's Observable, update method was created based on followers

Added project v2 features. User id is unique by design from the add user id button, but added a check anyways. Checks username for spaces since id can only store an int and an error is outputted if a user enters a non-int value for id.
